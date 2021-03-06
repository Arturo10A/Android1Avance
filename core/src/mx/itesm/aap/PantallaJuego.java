package mx.itesm.aap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

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


    private Stage escenaJuego;
    private Texture texturaBtnGoBack; //Boton de regreso


    //Texto

    private Texto texto;



    public PantallaJuego(Juego juego) {


        this.juego = juego;
    }

    public void cargarTexturas(){
        texturaBtnGoBack = new Texture("button_pause.png");

    }

    public void crearEscena(){
        escenaJuego = new Stage(vista);

        //Boton GOBACK

        TextureRegionDrawable trdGoBack = new TextureRegionDrawable(new TextureRegion(texturaBtnGoBack));
        ImageButton btnGoBack = new ImageButton(trdGoBack);

        btnGoBack.setPosition(ANCHO-btnGoBack.getWidth()-5,ALTO-btnGoBack.getHeight()-5);

        escenaJuego.addActor(btnGoBack);

        btnGoBack.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.log("clicked","***GO BACK***");
                juego.setScreen(new PantallaMenu(juego));
            }

        });
    }

    @Override
    public void show() {

        cargarTexturas();
        crearEscena();

        textureEcenario = new Texture("inicio.png");
        personaje = new Personaje(ANCHO/4,ALTO/2);

        Gdx.input.setInputProcessor(escenaJuego);
        //Gdx.input.setInputProcessor(new ProcesadorEventos());

        texto = new Texto();
    }

    @Override
    public void render(float delta) {

        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined);

        batch.begin();

        batch.draw(textureEcenario,Pantalla.ANCHO/2-textureEcenario.getWidth()/2, Pantalla.ALTO/2-textureEcenario.getHeight()/2);

        //Dibujar personaje
        personaje.render(batch);


        texto.mostrarMensaje(batch,"Vida: 100%",50,Pantalla.ALTO/1.02f);

        batch.end();

        batch.begin();
        escenaJuego.draw();
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

   /* private class ProcesadorEventos implements InputProcessor{

        @Override
        public boolean keyDown(int keycode) {

            if (keycode == Input.Keys.LEFT){
                personaje.mover(-DX_PERSONAJE,0);
            }if (keycode == Input.Keys.RIGHT){
                personaje.mover(DX_PERSONAJE,0);
            }if (keycode == Input.Keys.DOWN){
                personaje.mover(0,-DY_PERSONAJE);
            }if (keycode == Input.Keys.UP){
                personaje.mover(0,DY_PERSONAJE);
            }

            return true;
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
    }*/
}
