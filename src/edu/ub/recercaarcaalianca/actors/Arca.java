package edu.ub.recercaarcaalianca.actors;

import java.time.Clock;
import edu.ub.recercaarcaalianca.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static edu.ub.recercaarcaalianca.Constants.*;

public class Arca extends AbstractActor {

    private Image image;
    private int amplada;
    private int alcada;
    private String nom ;
    private String fitxer;

    public Arca() {
        this.nom = "Arca_Alianca";
        this.image = Util.carregarImatge("arca32.png");
        this.amplada = 32;
        this.alcada = 43;
        this.fitxer = "arca32.png";
        setEstat(Constants.ESTAT_ACTIU);
    }

    public void actualitzar(Context context) {
        // no fem res, es estàtic
    }

    public Rectangle getLimits() {
        return new Rectangle(getX(), getY(), amplada, alcada);
    }

    public void tractarColisio(Colisio colisio) {
        Actor actor = colisio.getActor();
        Arqueologa h = (Arqueologa) actor;   
        h.setArcaEncontrada(true);
    }

    public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.CYAN);
        Font f = new Font("Dialog", Font.BOLD, 12);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
           
}