package org.example;

import java.util.ArrayList;
import java.util.Stack;
import org.variantsync.diffdetective.variation.DiffLinesLabel;
import org.variantsync.diffdetective.variation.NodeType;
import org.variantsync.diffdetective.variation.tree.VariationTree;
import org.variantsync.diffdetective.variation.tree.VariationTreeNode;

public class TreeUnparser {
  public static String unparser(VariationTree<DiffLinesLabel> tree){
    StringBuilder result = new StringBuilder();
    Stack<VariationTreeNode<DiffLinesLabel>> stack = new Stack<>();
    for (int i = tree.root().getChildren().size()-1; i>=0;i--) {
      stack.push(tree.root().getChildren().get(i));
    }
    while (!stack.empty()){
      VariationTreeNode<DiffLinesLabel> node = stack.pop();
      for(String line :node.getLabel().getLines()){
        result.append(line);
        result.append("\n");
      }

      if(!node.isArtifact() && !(node.getChildren().get(node.getChildCount()-1).isElse() || node.getChildren().get(node.getChildCount()-1).isElif())){
        ArrayList<String> list = new ArrayList<>();
        list.add(node.getLabel().toString().split("#")[0] + "#endif");
        stack.push(new VariationTreeNode<>(NodeType.ARTIFACT, null,null, DiffLinesLabel.withInvalidLineNumbers(list) ));
      }
      for(int i = node.getChildren().size() -1 ; i>=0;i--){
        stack.push(node.getChildren().get(i));
      }
    }
    return result.substring(0,result.length()-1);
  }
}
