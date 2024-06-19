package org.example;

import static org.variantsync.diffdetective.util.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.IOUtils;
import org.variantsync.diffdetective.diff.result.DiffParseException;
import org.variantsync.diffdetective.variation.tree.VariationTree;

public class Test {



  public void whenFilesIdentical_thenReturnTrue() throws IOException, DiffParseException {
    Path dir = Path.of("Code","daten");
    Path path1 = dir.resolve("test.txt");
    Path path2 = Files.createTempFile("file2Test", ".txt");

    InputStream inputStream1 = new FileInputStream(path1.toFile());
    InputStream inputStream2 = new FileInputStream(path2.toFile());

    Files.writeString(path2, parunpar(path1));


    assertTrue(IOUtils.contentEquals(inputStream1, inputStream2));

    Reader reader1 = new BufferedReader(new FileReader(path1.toFile()));
    Reader reader2 = new BufferedReader(new FileReader(path2.toFile()));

    assertTrue(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
  }



  public void testSimple1() throws IOException, DiffParseException {
    Path dir = Path.of("Code","daten");
    Path path1 = dir.resolve("simple_v1.txt");
    Path path2 = Files.createTempFile("file2Test", ".txt");

    InputStream inputStream1 = new FileInputStream(path1.toFile());
    InputStream inputStream2 = new FileInputStream(path2.toFile());

    Files.writeString(path2, parunpar(path1));


    System.out.println(IOUtils.contentEquals(inputStream1, inputStream2));

    Reader reader1 = new BufferedReader(new FileReader(path1.toFile()));
    Reader reader2 = new BufferedReader(new FileReader(path2.toFile()));

    System.out.println(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
  }

  public void testSimple2() throws IOException, DiffParseException {
    Path dir = Path.of("Code","daten");
    Path path1 = dir.resolve("simple_v2.txt");
    Path path2 = Files.createTempFile("file2Test", ".txt");

    InputStream inputStream1 = new FileInputStream(path1.toFile());
    InputStream inputStream2 = new FileInputStream(path2.toFile());

    Files.writeString(path2, parunpar(path1));


    System.out.println(IOUtils.contentEquals(inputStream1, inputStream2));
    Reader reader1 = new BufferedReader(new FileReader(path1.toFile()));
    Reader reader2 = new BufferedReader(new FileReader(path2.toFile()));

    System.out.println(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
  }


  public void testSimple3() throws IOException, DiffParseException {
    Path dir = Path.of("Code","daten");
    Path path1 = dir.resolve("simple_v3.txt");
    Path path2 = Files.createTempFile("file2Test", ".txt");

    InputStream inputStream1 = new FileInputStream(path1.toFile());
    InputStream inputStream2 = new FileInputStream(path2.toFile());

    Files.writeString(path2, parunpar(path1));


    System.out.println(IOUtils.contentEquals(inputStream1, inputStream2));
    Reader reader1 = new BufferedReader(new FileReader(path1.toFile()));
    Reader reader2 = new BufferedReader(new FileReader(path2.toFile()));

    System.out.println(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
  }

  public void testSimple4() throws IOException, DiffParseException {
    Path dir = Path.of("Code","daten");
    Path path1 = dir.resolve("simple_v4.txt");
    Path path2 = Files.createTempFile("file2Test", ".txt");

    InputStream inputStream1 = new FileInputStream(path1.toFile());
    InputStream inputStream2 = new FileInputStream(path2.toFile());

    Files.writeString(path2, parunpar(path1));


    System.out.println(IOUtils.contentEquals(inputStream1, inputStream2));
    Reader reader1 = new BufferedReader(new FileReader(path1.toFile()));
    Reader reader2 = new BufferedReader(new FileReader(path2.toFile()));

    System.out.println(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
  }

  public String parunpar(Path path) throws IOException, DiffParseException {
    String temp = TreeUnparser.unparser(VariationTree.fromFile(path));
    System.out.println(temp);
    return temp;
  }
}
