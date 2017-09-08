package mx.itesm.aap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Arturo on 05/09/17.
 */

class PantallaJuego extends Pantalla {

    private final Juego juego;
    private Texture textureEcenario;  //Imagen del ecenario

    private float DX = 28;
    private int pasos = 10;
    private float timerPasos = 0;

    private  Personaje personaje;
    private int DX_PERSONAJE=10;
    private int DY_PERSONAJE =10;

    public PantallaJuego(Juego juego) {


        this.juego = juego;
    }

    @Override
    public void show() {

        textureEcenario = new Texture("back.jpg");
        personaje = new Personaje(ANCHO/2,ALTO/2);

        Gdx.input.setInputProcessor(new ProcesadorEventos());
    }

    @Override
    public void render(float delta) {

        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined);

        batch.begin();

        batch.draw(textureEcenario,Pantalla.ANCHO/2-textureEcenario.getWidth()/2, Pantalla.ALTO/2-textureEcenario.getHeight()/2);

        //Dibujar personaje
        personaje.render(batch);


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

    private class ProcesadorEventos implements InputProcessor{

        @Override
        public boolean keyDown(int keycode) {

            if (keycode == Input.Keys.LEFT){
                personaje.mover(-DX_PERSONAJE);
            }if (keycode == Input.Keys.RIGHT){
                personaje.mover(DX_PERSONAJE);
            }

            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return false;
        }
    }
}
