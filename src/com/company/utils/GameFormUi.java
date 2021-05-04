package com.company.utils;

import com.company.constans.Settings;
import com.sun.source.doctree.SeeTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public  class GameFormUi {
    JFrame GAME_FORM = new JFrame("GAME");
    
    int pressedButtonNumber=0;
    
    public void createGameForm() {
        GAME_FORM.setLayout(null);
        GAME_FORM.setVisible(true);
        GAME_FORM.setResizable(false);
        GAME_FORM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GAME_FORM.setBounds(Settings.FORM_POSITION_COORD, Settings.FORM_POSITION_COORD, Settings.FORM_WIDTH, Settings.FORM_HEIGHT);
    
        creatButtons();
        
        GAME_FORM.repaint();
    }
           void creatButtons()
    {
        int [] buttonNumbers = ArrayTools.generateArray(Settings.BUTTONS_AMOUNT);
        for (int buttonNumber:buttonNumbers)
        {
            JButton gameButton = new JButton();
            gameButton.setName(String.valueOf(buttonNumber));
            gameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pressedButtonNumber == Integer.parseInt(gameButton.getName()))
                    {
                        gameButton.setText("");
                        pressedButtonNumber = 0;
                    }
                    else
                    {
                         gameButton.setText(gameButton.getName());
                         pressedButtonNumber=Integer.parseInt(gameButton.getName());
                    }
                  //  System.out.println(gameButton.getName());
        
                }
            });
            gameButton.setBounds(Settings.xCoord, Settings.yCoord,Settings.BUTTONS_WIDTH_HEIGHT,Settings.BUTTONS_WIDTH_HEIGHT);
            //gameButton.setText(String.valueOf(buttonNumber));
            GAME_FORM.add(gameButton);
            
            Settings.xCoord = Settings.xCoord+110;
            if (Settings.xCoord>340)
            {
                Settings.xCoord=10;
                Settings.yCoord= Settings.yCoord+Settings.FORM_POSITION_COORD+ Settings.xCoord;
            }
        }
        
        
    }
    }
