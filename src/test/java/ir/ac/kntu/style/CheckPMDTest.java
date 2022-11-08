/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu.style;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author hossein
 */
public class CheckPMDTest {

    @Test
    public void testPMD() {

        /*
         * Files
         */
        File ROOT = new File("src/main/");
        System.out.println("Root is set to \"" + ROOT.getAbsolutePath() + "\".");

        List<File> files = new ArrayList<>();
        listFiles(files, ROOT, "java");
        System.out.println("Found " + files.size() + " Java source files.");

        PMDConfiguration pmdConfiguration = new PMDConfiguration();
        pmdConfiguration.setRuleSets("category/java/bestpractices.xml/DefaultLabelNotLastInSwitchStmt,"
                + "category/java/design.xml/ExcessiveMethodLength,"
                + "category/java/errorprone.xml/UseEqualsToCompareStrings");
        
        
        String collect = files.stream()
                .map(File::getPath)
                .collect(Collectors.joining(","));
        pmdConfiguration.setInputPaths(collect);
        pmdConfiguration.setReportFormat("text");
        int violations = PMD.doPMD(pmdConfiguration);
        Assert.assertEquals("No Vilation in Resource Closing", 0, violations);
    }

    
    private static void listFiles(List<File> files, File folder, String extension) {
        if (folder.canRead()) {
            if (folder.isDirectory()) {
                for (File f : folder.listFiles()) {
                    listFiles(files, f, extension);
                }
            } else if (folder.toString().endsWith("." + extension)) {
                files.add(folder);
            }
        }
    }
}
