
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        manager.addCharacter(
                new Character("Gatotkaca", CharacterType.WARRIOR, 7));

        manager.addCharacter(
                new Character("Morgana", CharacterType.MAGE, 1));

        manager.addCharacter(
                new Character("Artemis", CharacterType.ARCHER, 6));

        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 8));

        manager.addCharacter(
                new Character("Aurora", CharacterType.HEALER, 2));

        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                    manager.getAllCharacters()
            );

            window.setVisible(true);
        });
    }
}
