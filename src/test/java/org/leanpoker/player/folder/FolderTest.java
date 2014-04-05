/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.folder;

import org.junit.Test;
import static org.junit.Assert.*;
import org.leanpoker.player.IGameState;
import org.leanpoker.player.preflop.TestGameState;

/**
 *
 * @author athalay
 */
public class FolderTest {
    
    public FolderTest() {
    }

    @Test
    public void testSomeMethod() {
        IGameState testGameState = new TestGameState(
                "diamonds", 
                "hearts", 
                "A", 
                "K", 
                0, 
                0);
        Folder  folder = new Folder(testGameState);
        assertEquals(false, folder.isHaveToFold());
    }
    @Test
    public void testFold() {
        IGameState testGameState = new TestGameState(
                "diamonds", 
                "hearts", 
                "Q", 
                "K", 
                0, 
                0);
        Folder  folder = new Folder(testGameState);
        assertEquals(true, folder.isHaveToFold());
    }
}