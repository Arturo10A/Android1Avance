package mx.itesm.aap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import mx.itesm.aap.Juego;

/**
 * Created by Arturo on 25/08/17.
 */

class PantallaMenu extends Pantalla {

    private final Juego juego;

    //Contenedor de los botones
    private Stage escenaMenu;

    //Texturas de los botones
    private Texture texturaBtnJugar;
    private Texture texturaBtnAyuda;

    public PantallaMenu(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {

        cargarTexturas(); //Carga imagenes
        crearEcenaMenu(); //Crea la escena
        Gdx.input.setInputProcessor(escenaMenu);

    }

    private void cargarTexturas() {
        texturaBtnJugar = new Texture("Jugar.png");
        texturaBtnAyuda = new Texture("ayuda.png");
    }

    private void crearEcenaMenu() {

        escenaMenu = new Stage(vista);

        //Boton jugar

        TextureRegionDrawable trdPlay = new TextureRegionDrawable(new TextureRegion(texturaBtnJugar));
        ImageButton btnPlay = new ImageButton(trdPlay);


        btnPlay.setPosition(ANCHO/4-btnPlay.getWidth()/2,0.1f*ALTO);
        escenaMenu.addActor(btnPlay);

        //Listener del Botón
        btnPlay.addListener( new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.log("clicked","***PANTALLA JUEGO***");
                juego.setScreen(new PantallaJuego(juego));
            }
        });



        TextureRegionDrawable trdAyuda = new TextureRegionDrawable(new TextureRegion(texturaBtnAyuda));
        ImageButton btnAyuda = new ImageButton(trdAyuda);

        btnAyuda.setPosition(ANCHO/2-btnAyuda.getWidth()/8,0.1f*ALTO);
        escenaMenu.addActor(btnAyuda);


        btnAyuda.addListener( new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.log("clicked","***AYUDA PANTALLA***");
                juego.setScreen(new PantallaAyuda(juego));
            }


        });
    }

    @Override
    public void render(float delta) {
        borrarPantalla(0.0f,0.0f,0.0f);
        batch.setProjectionMatrix(camara.combined);
        escenaMenu.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
