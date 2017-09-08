package mx.itesm.aap;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Arturo on 08/09/17.
 */

class PantallaAyuda extends Pantalla {

    private final Juego juego;

    private Texture ecenario;  //Imagen del ecenario

    private Texture texturaFondoPantallaAyudad;

    public PantallaAyuda(Juego juego) {

        this.juego = juego;

    }

    @Override
    public void show() {

        //Fondo para este ecenario
        texturaFondoPantallaAyudad = new Texture("img.jpg");


    }

    @Override
    public void render(float delta) {

        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        batch.draw(texturaFondoPantallaAyudad, Pantalla.ANCHO/2-texturaFondoPantallaAyudad.getWidth()/2,
                Pantalla.ALTO/2-texturaFondoPantallaAyudad.getHeight()/2);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
