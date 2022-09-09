package com.hcp.gameengine.file;

import javafx.scene.Group;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.List;




/* Created by: Jesse
 * Create Datetime: 09/05/2022 02:26 P.M.
 * Class: GeneralFileHandler
 * Purpose: To handle general file input/output.
 *          Should provide function to read any file content as a string, or read json or xml as an object.
 * Last Modified: 09/05/2022 03:01 P.M. by Jesse
 */
public class GeneralFileHandler {
    //exportFileGeneral
    //desc: A function that exports any Serializable object.
    //parameters: filePath, fileName, fileContent
    //  filePath: the destination path to export, does not include filename.
    //  fileName: the destination file's filename, should never include the path
    //  fileContent: the object to export
    //returns: a number indicates success status
    public static int exportFileGeneral(String filePath, String fileName, Object fileContent) {
        filePath=filePathCombiner(filePath,fileName);
        return exportFileGeneral(filePath, fileContent);        //handle the actual export
    }


    //exportFileGeneral
    //desc: A function that exports any Serializable object.
    //parameters: filePath, fileContent
    //  filePath: the destination path to export, include filename.
    //  fileContent: the object to export
    //returns: a number indicates success or not
    public static int exportFileGeneral(String filePath, Object fileContent) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(fileContent);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return 1;  //return 1 if io error occurred
        } catch (Exception e){
            e.printStackTrace();
            return -1;  //return 1 if other unexpected exception occurred
        }
        return 0;       //return 0 for success export
    }

    //importFileGeneral
    //desc: A function that imports any Serializable object.
    //parameters: filePath, fileName, fileContent
    //  filePath: the destination path to export, does not include filename.
    //  fileName: the destination file's filename, should never include the path
    //returns: an object read from the given path, null if exception occurred.
    public static Object importFileGeneral(String filePath, String fileName) {
        filePath=filePathCombiner(filePath,fileName);
        return importFileGeneral(filePath);
    }

    //importFileGeneral
    //desc: A function that imports any Serializable object.
    //parameters: filePath, fileName, fileContent
    //  filePath: the destination path to export, include filename.
    //returns: an object read from the given path, null if exception occurred.
    public static Object importFileGeneral(String filePath){
        Object _object;
        try
        {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            _object = in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return null;
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return _object;
    }

    //filePathCombiner
    //desc: A function that combines the file path and file name together
    //parameters: filePath, fileName
    //  filePath: the destination path, does not include filename.
    //  fileName: the destination file's filename, should never include the path
    private static String filePathCombiner(String filePath, String fileName){
        if(!filePath.endsWith(fileName)) {                          //only execute when filename is not already in the file path
            if (filePath.charAt(filePath.length() - 1) != '\\')     //if file path is not ended with "\"
            {
                filePath += "\\";
            }
            filePath += fileName;                                   //put file path and filename together
        }
        return filePath;
    }

    //  configParser
    //  desc: A method that parses XML from the config file and returns a group of subWindows
    //  params: filePath
    //      filePath: Path to the XML document
    public Group configParser(String filePath) {
        Group root = new Group();

        try {
            // Get the doc
            File inFile = new File(filePath);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inFile);

            // Get the root element, in our case "BaseWindow"
            Element rootElement = document.getRootElement();
            List<Element> subWindows = rootElement.getChildren();

            for (Element e : subWindows) {
                String type = e.getChild("Type").getText();
                int height = Integer.parseInt(e.getChild("Height").getValue());
                int width = Integer.parseInt(e.getChild("Width").getValue());
                int xPos = Integer.parseInt(e.getChild("xPosition").getValue());
                int yPos = Integer.parseInt(e.getChild("yPosition").getValue());

                // Add to the root
                //Todo: Figure out how to add to the root
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return root;
    }


}
