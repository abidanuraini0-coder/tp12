
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
        // Class tema tidak perlu dibuat menjadi objek.
    }

    // ==================================
    // WARNA UTAMA
    // ==================================
    public static final Color BACKGROUND =
            new Color(245, 247, 250);

    public static final Color SURFACE =
            new Color(255, 255, 255);

    public static final Color TEXT =
            new Color(40, 45, 55);

    public static final Color SECONDARY_TEXT =
            new Color(100, 110, 125);

    // ==================================
    // WARNA STATUS BAR
    // ==================================
    public static final Color BG_STATUS =
            Color.decode("#0d0d1a");

    public static final Color TEXT_MUTED =
            Color.decode("#9d9dbf");

    // ==================================
    // WARNA KARTU BERDASARKAN ROLE
    // ==================================
    public static final Color WARRIOR_COLOR =
            new Color(255, 226, 220);

    public static final Color MAGE_COLOR =
            new Color(230, 222, 255);

    public static final Color ARCHER_COLOR =
            new Color(218, 244, 225);

    public static final Color HEALER_COLOR =
            new Color(218, 238, 255);

    // ==================================
    // WARNA BORDER BERDASARKAN ROLE
    // ==================================
    public static final Color WARRIOR_BORDER =
            new Color(210, 95, 75);

    public static final Color MAGE_BORDER =
            new Color(125, 90, 200);

    public static final Color ARCHER_BORDER =
            new Color(50, 145, 85);

    public static final Color HEALER_BORDER =
            new Color(55, 125, 200);

    // ==================================
    // WARNA LEVEL TINGGI
    // ==================================
    public static final Color HIGH_LEVEL_COLOR =
            new Color(184, 134, 11);

    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // ==================================
    // FONT
    // ==================================
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.PLAIN, 26);

    public static final Font HEADING_FONT =
            new Font("SansSerif", Font.PLAIN, 16);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font SMALL_FONT =
            new Font("SansSerif", Font.PLAIN, 12);

    public static final Font HIGH_LEVEL_FONT =
            new Font("SansSerif", Font.BOLD, 16);

    // ==================================
    // BORDER
    // ==================================
    public static final Border WINDOW_BORDER =
            BorderFactory.createEmptyBorder(20, 20, 20, 20);

    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(220, 225, 232), 1
                    ),
                    BorderFactory.createEmptyBorder(14, 16, 14, 16)
            );

    public static final Border SECTION_BORDER =
            BorderFactory.createEmptyBorder(8, 0, 8, 0);

    // ==================================
    // WARNA KARTU BERDASARKAN ROLE
    // ==================================
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return SURFACE;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case HEALER:
                return HEALER_COLOR;

            default:
                return SURFACE;
        }
    }

    // ==================================
    // BORDER BERDASARKAN ROLE
    // ==================================
    public static Border borderFor(CharacterType type) {

        Color borderColor;

        if (type == null) {
            borderColor = new Color(220, 225, 232);
        } else {
            switch (type) {
                case WARRIOR:
                    borderColor = WARRIOR_BORDER;
                    break;

                case MAGE:
                    borderColor = MAGE_BORDER;
                    break;

                case ARCHER:
                    borderColor = ARCHER_BORDER;
                    break;

                case HEALER:
                    borderColor = HEALER_BORDER;
                    break;

                default:
                    borderColor = new Color(220, 225, 232);
            }
        }

        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 2),
                BorderFactory.createEmptyBorder(14, 16, 14, 16)
        );
    }

    // ==================================
    // DESKRIPSI SETIAP ROLE
    // ==================================
    public static String describe(CharacterType type) {

        if (type == null) {
            return "Role tidak diketahui";
        }

        switch (type) {
            case WARRIOR:
                return "Petarung dengan kemampuan fisik kuat";

            case MAGE:
                return "Pengguna kekuatan sihir";

            case ARCHER:
                return "Petarung yang menggunakan busur";

            case HEALER:
                return "Karakter dengan kemampuan penyembuhan";

            default:
                return "Karakter dengan role khusus";
        }
    }
}
