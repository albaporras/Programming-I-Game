/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.recercaarcaalianca.actors;
import edu.ub.recercaarcaalianca.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static edu.ub.recercaarcaalianca.Constants.*;

/**
 *
 * @author alba
 */
public class Diamant extends AbstractActor {
  
    private static final Rectangle DIMENSIONS_ICONA = new Rectangle(0, 0, 50, 30);
    private Image[] icones;
    private int targetX;
    private int targetY;
    private boolean hasTarget;
    private boolean aturat;
    
    private float energia_diamant; 
    public static enum TipusDiamant{VERMELL,BLAU,VERD,GROC,TARONJA};
    private TipusDiamant tipus;
    private String diamant;
 
        
    public Diamant(TipusDiamant tipus) {
        this.tipus = tipus;
       
        icones = new Image[2];
        BufferedImage iTmp = null; 
        
        switch (tipus){
            case VERMELL:
                iTmp = Util.carregarImatge("DiamondRed.png");
                this.energia_diamant = 15;
                break;
            case BLAU:
                iTmp = Util.carregarImatge("DiamondBlue.png");
                this.energia_diamant = 10;
                break;
            case VERD:
                iTmp = Util.carregarImatge("DiamondGreen.png");
                this.energia_diamant = 5;
                break;
            case GROC:
                iTmp = Util.carregarImatge("DiamondYellow.png");
                this.energia_diamant = 5;
                break;
            case TARONJA:
                iTmp = Util.carregarImatge("DiamondOrange.png");
                this.energia_diamant = 5;
                break;
        }
        
        icones[0] = Util.flipImatgeHor(iTmp);
        icones[1] = iTmp;
    }

    /**
     * Sobreescriu el metode per canviar de direccio cada cop que xoca amb un
     * mur.
     *
     * @param context
     */
    public void actualitzar(Context context) {
        //estático

    }

    public String getDiamant() {
        return diamant;
    }
    
    public void setDiamant(String diamant) {
        this.diamant = diamant;
    }
    
    public Rectangle getLimits() {
        return new Rectangle(getX(), getY(), DIMENSIONS_ICONA.width, DIMENSIONS_ICONA.height);
    }

    public void tractarColisio(Colisio colisio) {
        Actor actor = colisio.getActor();
        
        // TODO alumnes, gestio de la colisio amb l'arqueologa 
        actor.setVida(Math.max(0, Math.min(100.0f, actor.getVida() + energia_diamant)));
        setEstat(Constants.ESTAT_INACTIU);
        
        TipusDiamant vermell = TipusDiamant.VERMELL;
        TipusDiamant blau = TipusDiamant.BLAU;
        TipusDiamant verd = TipusDiamant.VERD;
        TipusDiamant groc = TipusDiamant.GROC;
        TipusDiamant taronja = TipusDiamant.TARONJA;
     
        if(actor instanceof Arqueologa){ 
         Arqueologa h = (Arqueologa) actor;
         String[] dia = h.getDiamantes();

            if (tipus == vermell &&  h.getComprobar()[0]==false){ 
            dia [0] = tipus.toString();
              h.setComprobar(0, true);
                h.setDiamantes(dia);

            }
            if (tipus == blau &&  h.getComprobar()[1]==false){ 
            dia [1] = tipus.toString();
                h.setComprobar(1, true);
                h.setDiamantes(dia);
            }
            else if (tipus == groc &&  h.getComprobar()[2]==false){ 
            dia [2] = tipus.toString();
                h.setComprobar(2, true);
                h.setDiamantes(dia);
            }
            else if (tipus == verd &&  h.getComprobar()[3]==false){ 
            dia [3] = tipus.toString();
                h.setComprobar(3, true);
                h.setDiamantes(dia);
            }
            else if(tipus == taronja &&  h.getComprobar()[4]==false){ 
            dia [4] = tipus.toString();
                h.setComprobar(4, true);
                h.setDiamantes(dia);
            }
    }    
    }       
    
         
    public void render(Graphics2D g) {
        int currentIcona = 0;
        g.drawImage(icones[currentIcona], getX(), getY(), observer);
    }

    public boolean isAturat() {
        return aturat;
    }

    public void setAturat(boolean aturat) {
        this.aturat = aturat;
    }
    
    /**
     * Obte el nivell de força del soldat.
     *
     * @return un numero entre 0 i 100, 0 es mort.
     */
    public float getEnergia() {
        return energia_diamant;
    }
    
    /**
     * Estableix el nivell de forca.
     *
     * @param Forca un numero enter 0 i 100
     */
    public void setEnergia(float Energia) {
        this.energia_diamant = Math.max(0, Math.min(100, Energia));
    }
    
    
    // *********************************************************
    // ****** private methods***********************************
    // *********************************************************

    private void init() {
        
    }
    
    private boolean getXocaContraMurs(Rectangle limits, Cambra h) {
        boolean xoca = false;
        int[][] celes = h.getCelesIntersectades(limits);
        int i = 0;
        
        while (i < celes.length && !xoca) {
            if (h.getValor(celes[i][0], celes[i][1]) == SIMBOL_MUR)
                xoca = true;
            i++;
        }
        return xoca;
    }

    
}
