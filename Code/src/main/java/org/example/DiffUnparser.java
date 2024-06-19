package org.example;

import java.util.Stack;
import org.variantsync.diffdetective.variation.DiffLinesLabel;
import org.variantsync.diffdetective.variation.diff.DiffNode;
import org.variantsync.diffdetective.variation.diff.VariationDiff;

public class DiffUnparser {
  public static String unparser(VariationDiff<DiffLinesLabel> diff){
    StringBuilder result = new StringBuilder();
    Stack<DiffNode<DiffLinesLabel>> stack = new Stack<>();
    return result.toString();
  }
}
