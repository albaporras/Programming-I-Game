package edu.ub.recercaarcaalianca;

import edu.ub.recercaarcaalianca.actors.*;

import static edu.ub.recercaarcaalianca.Constants.*;

/**
 * Demo.
 */
public class Practica {

    private final Joc joc;
    private final Temple temple;
    private final Arqueologa cindy_jones;


    private Practica() {

        temple = new Temple(3, 3);
        //NIVEL 0
        temple.addCambra(0, 0, crearCambra0Nivell0());
        temple.addCambra(0, 1, crearCambra1Nivell0());
        temple.addCambra(0, 2, crearCambra2Nivell0());
        
        //NIVEL 1
        temple.addCambra(1, 0, crearCambra0Nivell1());
        temple.addCambra(1, 1, crearCambra1Nivell1());
        temple.addCambra(1, 2, crearCambra2Nivell1());
        
        //NIVEL 2
        temple.addCambra(2, 0, crearCambra0Nivell2());
        temple.addCambra(2, 1, crearCambra1Nivell2());
        temple.addCambra(2, 2, crearCambra2Nivell2());

        cindy_jones = new Arqueologa();
        Cambra cam = temple.getCambra(0, 0);
        int[] p = cam.getPosicioCela(10, 10);
        cindy_jones.setPosicioInicial(p[0], p[1]);

        
        distribuirSoldats();
        distribuirDiamant();

        //initialitzacio del joc
        joc = new Joc(temple, cindy_jones);
        GuiJoc gui = new GuiJoc(joc);
    }

    /**
     * Principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Practica();
    }

    //NIVEL 0
    private Cambra crearCambra0Nivell0() {
        Cambra cam = Util.carregarCambra("c0_0.txt");

        Porta porta = cam.getPorta(14, 24);
        porta.setNumNivellDesti(0);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(cam.getPosicioCela(1, 1));

        porta = cam.getPorta(0, 10);
        porta.setNumNivellDesti(0);
        porta.setNumCambraDesti(2);
        porta.setPosicioCambraDesti(cam.getPosicioCela(14, 10));

        return cam;
    }

    private Cambra crearCambra1Nivell0() {
        Cambra h = Util.carregarCambra("c0_1.txt");

        Porta porta = h.getPorta(1, 0);
        porta.setNumNivellDesti(0);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(13, 22));

        porta = h.getPorta(0, 17);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(14, 2));

        return h;
    }

    private Cambra crearCambra2Nivell0() {
        Cambra h = Util.carregarCambra("c0_2.txt");
        
        Porta porta = h.getPorta(16, 10);
        porta.setNumNivellDesti(0);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 10));

        return h;
    }
    
    //NIVEL1
     private Cambra crearCambra0Nivell1() {
        Cambra h = Util.carregarCambra("c0_3.txt");
        
        Porta porta = h.getPorta(16, 2);
        porta.setNumNivellDesti(0);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 17));
        
        porta = h.getPorta(16, 23);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 1));
      
        return h;
     }
    
     private Cambra crearCambra1Nivell1() {
        Cambra h = Util.carregarCambra("c0_4.txt");
        
        Porta porta = h.getPorta(0, 1);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(13, 23));
        
        porta = h.getPorta(16, 1);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(2);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 22));
      
        return h;
     }
     
    private Cambra crearCambra2Nivell1() {
        Cambra h = Util.carregarCambra("c0_5.txt");
        
        Porta porta = h.getPorta(0, 22);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(h.getPosicioCela(14, 1));
        
        porta = h.getPorta(8, 0);
        porta.setNumNivellDesti(2);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(8, 23));
      
        return h;
     }
    
    //NIVEL 2
    private Cambra crearCambra0Nivell2() {
        Cambra h = Util.carregarCambra("c0_6.txt");
        
        Porta porta = h.getPorta(8, 24);
        porta.setNumNivellDesti(1);
        porta.setNumCambraDesti(2);
        porta.setPosicioCambraDesti(h.getPosicioCela(8, 1));
        
        porta = h.getPorta(1, 0);
        porta.setNumNivellDesti(2);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(h.getPosicioCela(13, 23));
      
        return h;
    }
    
    private Cambra crearCambra1Nivell2() {
        Cambra h = Util.carregarCambra("c0_7.txt");
        
        Porta porta = h.getPorta(13, 24);
        porta.setNumNivellDesti(2);
        porta.setNumCambraDesti(0);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 1));
        
        porta = h.getPorta(0, 1);
        porta.setNumNivellDesti(2);
        porta.setNumCambraDesti(2);
        porta.setPosicioCambraDesti(h.getPosicioCela(13, 22));
      
        return h;
    }

    private Cambra crearCambra2Nivell2() {
        Cambra h = Util.carregarCambra("c0_8.txt");
        
        Porta porta = h.getPorta(15, 23);
        porta.setNumNivellDesti(2);
        porta.setNumCambraDesti(1);
        porta.setPosicioCambraDesti(h.getPosicioCela(1, 1));
        
        Arca arca = new Arca();        
        int[] p = h.getPosicioCela(1, 1);
        arca.setPosicioInicial(p[0], p[1]);
        h.addActor(arca);
        
        return h;
    }
    
    private Cambra getRandCambra() {
        int nivell;
        int numCambra;
        Cambra cam;
        nivell = (int) (Math.random() * temple.getNumNivells());
        numCambra = (int) (Math.random() * temple.getNumCambres(nivell));
        cam = temple.getCambra(nivell, numCambra);
        return cam;
    }

    private void distribuirSoldats() {
        int [] num = {1,3,6}; //nombre de soldats a distribuir de cada tipus
        boolean jefe=false;
        for (int i = 0; i < Soldat.TipusSoldat.values().length ; i++) {
            
            for(int t=0; t<3; t++){
                for(int k = 0; k < num[t] ; k++){
            
                    if (num[t]!=1){
                        int nivell = i; 
                        int numCambra = (int) (Math.random() * temple.getNumCambres(nivell));
                        Cambra cam = temple.getCambra(nivell, numCambra);
                        int[] cela = obtenirCelaLliure(cam);
                        Soldat s = new Soldat(Soldat.TipusSoldat.values()[t]);  

                        int[] posicio = cam.getPosicioCela(cela[0], cela[1]);
                        s.setPosicioInicial(posicio[0], posicio[1]);
                        cam.addActor(s);
                    }else{
                        if (!jefe){
                            int nivell = i; 
                            int numCambra = (int) (Math.random() * temple.getNumCambres(nivell));
                            Cambra cam = temple.getCambra(nivell, numCambra);
                            int[] cela = obtenirCelaLliure(cam);
                            Soldat s = new Soldat(Soldat.TipusSoldat.values()[t]);  

                            int[] posicio = cam.getPosicioCela(cela[0], cela[1]);
                            s.setPosicioInicial(posicio[0], posicio[1]);
                            cam.addActor(s); 
                            jefe=true;
                        }
                    }
                }
            }
        }
    }
      private void distribuirDiamant() {
        int [] num = {2,3,3,3,2}; //nombre de diamants a distribuir de cada tipus
         
        for (int i = 0; i < Diamant.TipusDiamant.values().length ; i++) {
            for(int k = 0; k < num[i] ; k++){
                int nivell = (int) (Math.random() * temple.getNumNivells());
                int numCambra = (int) (Math.random() * temple.getNumCambres(nivell));
                Cambra cam = temple.getCambra(nivell, numCambra);
                int[] cela = obtenirCelaLliure(cam);
                Diamant s = new Diamant(Diamant.TipusDiamant.values()[i]);  

                int[] posicio = cam.getPosicioCela(cela[0], cela[1]);
                s.setPosicioInicial(posicio[0], posicio[1]);
                cam.addActor(s);
            }
        }

    }

    private int[] obtenirCelaLliure(Cambra cambra) {
        int fila = 0;
        int col = 0;
        int cela[];
        boolean trobada = false;
        boolean terra;

        while (!trobada) {
            terra = false;
            while (!terra) {
                fila = (int) Math.max(0, (Math.random() * NUM_CELES_VERTICALS - 2));
                col = (int) Math.max(0, (Math.random() * NUM_CELES_HORIZONTALS - 2));
                terra = (cambra.getValor(fila, col) == SIMBOL_TERRA &&
                        cambra.getValor(fila + 1, col) == SIMBOL_TERRA &&
                        cambra.getValor(fila, col + 1) == SIMBOL_TERRA &&
                        cambra.getValor(fila + 1, col + 1) == SIMBOL_TERRA);
            }

            // comprovar que cap actor esta dins la cela
            Actor[] actors = cambra.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = cambra.getCela(actors[i].getPosicioInicial()[0],
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];
                i++;
            }

            //comprovar que el cindy_jones no esta dins la cela
            if (lliure) {
                cela = cambra.getCela(cindy_jones.getPosicioInicial()[0],
                        cindy_jones.getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];
            }

            trobada = lliure;
        }
        return new int[]{fila, col};
    }

}
