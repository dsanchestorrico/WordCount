/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bo.wordscount;

import java.io.IOException;

/**
 *
 * @author Daniel Sanchez
 */
public class WordCountClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        WordCount wordCount = new WordCount();
        wordCount.CountWordsInFile("words");
    }

}
