
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

    private final List<Character> characterList;

    public MainWindow(List<Character> characterList) {

        super("Character Manager v0.5");

        this.characterList = characterList;

        initComponents();

        pack();
        setMinimumSize(new Dimension(560, 380));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // ==========================================
    // KERANGKA UTAMA
    // ==========================================

    private void initComponents() {

        getContentPane().setBackground(AppTheme.BACKGROUND);

        setLayout(new BorderLayout());

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createListArea(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    // ==========================================
    // HEADER DAN PANEL STATISTIK
    // ==========================================

    private JPanel createHeaderPanel() {

        JPanel topPanel = new JPanel(new BorderLayout(8, 8));
        topPanel.setBackground(AppTheme.BACKGROUND);

        topPanel.setBorder(
                BorderFactory.createEmptyBorder(16, 16, 8, 16)
        );

        // Header utama
        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(AppTheme.SURFACE);
        header.setOpaque(true);

        JLabel title = new JLabel("CHARACTER MANAGER");

        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.TEXT);

        JLabel count = new JLabel(
                getValidCharacterCount() + " karakter"
        );

        count.setFont(AppTheme.HEADING_FONT);
        count.setForeground(AppTheme.HIGH_LEVEL_COLOR);

        header.add(title, BorderLayout.WEST);
        header.add(count, BorderLayout.EAST);

        // Panel statistik tambahan
        JPanel statistics = new JPanel(
                new GridLayout(1, 2, 12, 0)
        );

        statistics.setBackground(AppTheme.BACKGROUND);

        statistics.setBorder(
                BorderFactory.createEmptyBorder(8, 0, 4, 0)
        );

        JLabel total = new JLabel(
                "Total karakter: " + getValidCharacterCount()
        );

        JLabel average = new JLabel(
                "Rata-rata level: " + getAverageLevel()
        );

        total.setFont(AppTheme.BODY_FONT);
        total.setForeground(AppTheme.TEXT);

        average.setFont(AppTheme.BODY_FONT);
        average.setForeground(AppTheme.TEXT);

        statistics.add(total);
        statistics.add(average);

        topPanel.add(header, BorderLayout.NORTH);
        topPanel.add(statistics, BorderLayout.SOUTH);

        return topPanel;
    }

    // ==========================================
    // DATA STATISTIK
    // ==========================================

    private int getValidCharacterCount() {

        if (characterList == null) {
            return 0;
        }

        int total = 0;

        for (Character character : characterList) {
            if (character != null) {
                total++;
            }
        }

        return total;
    }

    private String getAverageLevel() {

        if (characterList == null) {
            return "0.00";
        }

        int totalLevel = 0;
        int totalCharacter = 0;

        for (Character character : characterList) {

            if (character != null) {
                totalLevel += character.getLevel();
                totalCharacter++;
            }
        }

        if (totalCharacter == 0) {
            return "0.00";
        }

        double average = (double) totalLevel / totalCharacter;

        return String.format("%.2f", average);
    }

    // ==========================================
    // DAFTAR KARAKTER BERSCROLL
    // ==========================================

    private JScrollPane createListArea() {

        JPanel cards = new JPanel(
                new GridLayout(0, 1, 0, 8)
        );

        cards.setBackground(AppTheme.BACKGROUND);
        cards.setOpaque(true);

        if (characterList != null) {

            for (Character character : characterList) {

                if (character != null) {
                    cards.add(createCharacterLabel(character));
                }
            }
        }

        // Panel pembungkus
        JPanel holder = new JPanel(new BorderLayout());

        holder.setBackground(AppTheme.BACKGROUND);
        holder.setOpaque(true);

        holder.setBorder(
                BorderFactory.createEmptyBorder(8, 16, 8, 8)
        );

        holder.add(cards, BorderLayout.NORTH);

        // Scroll pane
        JScrollPane scroll = new JScrollPane(holder);

        scroll.setBorder(null);

        scroll.getViewport().setBackground(AppTheme.BACKGROUND);

        scroll.setPreferredSize(new Dimension(460, 280));

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        return scroll;
    }

    // ==========================================
    // KARTU KARAKTER
    // ==========================================

    private JLabel createCharacterLabel(Character c) {

        CharacterType type = c.getType();

        String info = c.getName()
                + " | " + type
                + " | Lv." + c.getLevel()
                + " | HP:" + c.getHitPoints()
                + " | ATK:" + c.getAttack();

        JLabel label = new JLabel(info);

        label.setFont(AppTheme.BODY_FONT);

        label.setForeground(AppTheme.TEXT);

        label.setBackground(AppTheme.colorFor(type));

        label.setOpaque(true);

        label.setBorder(AppTheme.borderFor(type));

        label.setToolTipText(
                "<html>"
                + "<b>" + c.getName() + "</b><br>"
                + "Role: " + type + "<br>"
                + "Level: " + c.getLevel() + "<br>"
                + "HP: " + c.getHitPoints() + "<br>"
                + "ATK: " + c.getAttack() + "<br>"
                + "Mana: " + c.getMana()
                + "</html>"
        );

        label.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        // Mini-Challenge level tinggi
        if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {

            label.setFont(AppTheme.HIGH_LEVEL_FONT);

            label.setForeground(AppTheme.HIGH_LEVEL_COLOR);
        }

        return label;
    }

    // ==========================================
    // LEGENDA ROLE
    // ==========================================

    private JPanel createLegendPanel() {

        JPanel legend = new JPanel();

        legend.setLayout(
                new BoxLayout(legend, BoxLayout.Y_AXIS)
        );

        legend.setBackground(AppTheme.BACKGROUND);

        legend.setBorder(
                BorderFactory.createEmptyBorder(8, 8, 8, 16)
        );

        JLabel heading = new JLabel("LEGENDA ROLE");

        heading.setFont(AppTheme.HEADING_FONT);
        heading.setForeground(AppTheme.TEXT);

        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

        legend.add(heading);

        legend.add(Box.createVerticalStrut(8));

        // Legenda dibuat otomatis dari enum
        for (CharacterType type : CharacterType.values()) {

            JLabel chip = new JLabel(type.name());

            chip.setOpaque(true);

            chip.setBackground(AppTheme.colorFor(type));

            chip.setForeground(AppTheme.TEXT);

            chip.setFont(AppTheme.SMALL_FONT);

            chip.setBorder(AppTheme.borderFor(type));

            chip.setToolTipText(type.name());

            chip.setAlignmentX(Component.LEFT_ALIGNMENT);

            legend.add(chip);

            legend.add(Box.createVerticalStrut(6));
        }

        legend.add(Box.createVerticalGlue());

        legend.setPreferredSize(new Dimension(155, 280));

        return legend;
    }

    // ==========================================
    // STATUS BAR
    // ==========================================

    private JPanel createStatusPanel() {

        JPanel status = new JPanel(new BorderLayout());

        status.setBackground(AppTheme.BG_STATUS);

        status.setBorder(
                BorderFactory.createEmptyBorder(8, 16, 8, 16)
        );

        JLabel statusText = new JLabel(
                "Total: " + getValidCharacterCount()
                + " karakter  |  Siap"
        );

        statusText.setFont(AppTheme.SMALL_FONT);
        statusText.setForeground(AppTheme.TEXT_MUTED);

        JLabel version = new JLabel("v0.5");

        version.setFont(AppTheme.SMALL_FONT);
        version.setForeground(AppTheme.TEXT_MUTED);

        status.add(statusText, BorderLayout.WEST);
        status.add(version, BorderLayout.EAST);

        return status;
    }
}
