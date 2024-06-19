package org.example;

import java.io.IOException;
import java.util.Stack;
import org.eclipse.jgit.diff.DiffAlgorithm.SupportedAlgorithm;
import org.variantsync.diffdetective.variation.DiffLinesLabel;
import org.variantsync.diffdetective.variation.diff.DiffNode;
import org.variantsync.diffdetective.variation.diff.Time;
import org.variantsync.diffdetective.variation.diff.VariationDiff;
import org.variantsync.diffdetective.variation.diff.construction.JGitDiff;

public class DiffUnparser {
  public static String unparser(VariationDiff<DiffLinesLabel> diff) throws IOException {
    String tree1 = TreeUnparser.unparser(diff.project(Time.BEFORE));
    String tree2 = TreeUnparser.unparser(diff.project(Time.AFTER));
    return JGitDiff.textDiff(tree1,tree2, SupportedAlgorithm.MYERS);
  }
}
