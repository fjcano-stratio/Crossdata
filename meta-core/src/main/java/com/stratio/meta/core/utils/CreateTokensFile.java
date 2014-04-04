/*
 * Stratio Meta
 *
 * Copyright (c) 2014, Stratio, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package com.stratio.meta.core.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTokensFile {
    
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateTokensFile.class);
    
    public static void main(String[] args) {                
        try {
            String workingDir = System.getProperty("user.dir");
            if(workingDir.endsWith("stratio-meta")){
                workingDir = workingDir.concat("/meta-core/");
            } else if(!workingDir.endsWith("meta-core")){
                workingDir = workingDir.substring(0, workingDir.lastIndexOf("/"));
                workingDir = workingDir.concat("/meta-core/");
            } else {
                workingDir = workingDir.concat("/");
            }
            
            String metaGrammarPath = workingDir+"src/main/java/com/stratio/meta/core/grammar/Meta.g";
            String metaTokens = workingDir+"src/main/resources/com/stratio/meta/parser/tokens.txt";
            File fileGrammar = new File(metaGrammarPath);  
            File outFile = new File(metaTokens);

            logger.info("Reading grammar from "+fileGrammar.getAbsolutePath());
            BufferedWriter bw;
            try (BufferedReader br = new BufferedReader(new FileReader(fileGrammar))) {
                bw = new BufferedWriter(new FileWriter(outFile));
                String line = br.readLine();
                while (line != null){
                    if(line.startsWith("T_")){
                        String token = line.substring(2, line.indexOf(":")+2);
                        String replacement = line.substring(line.indexOf(":")+1);
                        replacement = replacement.replace(";", "");
                        replacement = replacement.replace("'", "");
                        replacement = replacement.replace(" ", "");
                        replacement = "[#"+replacement+"#]";
                        bw.write(token+replacement);
                        bw.newLine();
                    }
                    line = br.readLine();
                }
            }
            bw.flush();
            bw.close();            
            logger.info(outFile.getAbsolutePath()+" created");
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
    
}