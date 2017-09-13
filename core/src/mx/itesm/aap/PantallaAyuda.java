package mx.itesm.aap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Arturo on 08/09/17.
 */

class PantallaAyuda extends Pantalla {

    private final Juego juego;

    private Texture ecenario;  //Imagen del ecenario

    private Texture texturaFondoPantallaAyudad;

    private Texture goBackbotton;

    private Texto texto;

    private Stage ecenaAyuda;

    private Texture texturaBtnGoBack;



    public PantallaAyuda(Juego juego) {

        this.juego = juego;

    }

    @Override
    public void show() {

        cargarTexturas();
        crearEcenaAyuda();

        Gdx.input.setInputProcessor(ecenaAyuda);

        //Boto que deve de ser sustituido
        batch = new SpriteBatch();
        texto = new Texto();

    }

    public void cargarTexturas(){
        texturaBtnGoBack = new Texture("ayuda.png");

        //Fondo para este ecenario
        texturaFondoPantallaAyudad = new Texture("img.jpg");



    }

    public void crearEcenaAyuda(){

        ecenaAyuda = new Stage(vista);

        //Boton goBack
        TextureRegionDrawable trdGoBack = new TextureRegionDrawable(new TextureRegion(texturaBtnGoBack));
        ImageButton btnGoBack = new ImageButton(trdGoBack);

        btnGoBack.setPosition(ANCHO-btnGoBack.getWidth(),ALTO-btnGoBack.getHeight());

        //Fondo de pantalla

        TextureRegionDrawable backWall = new TextureRegionDrawable(new TextureRegion(texturaFondoPantallaAyudad));
        Image back = new Image(backWall);
        back.setPosition(ANCHO/2-back.getWidth()/2,ALTO/2-back.getHeight()/2);



        ecenaAyuda.addActor(back);
        ecenaAyuda.addActor(btnGoBack);

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
    public void render(float delta) {

        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined);

        batch.begin();

        texto.mostrarMensaje(batch,"Rodrigo Narvaez",Pantalla.ANCHO/2,Pantalla.ALTO/1.5f);
        texto.mostrarMensaje(batch,"Monse Designer",Pantalla.ANCHO/2,Pantalla.ALTO/1.7f);
        texto.mostrarMensaje(batch,"Alexis",Pantalla.ANCHO/2,Pantalla.ALTO/1.9f);
        texto.mostrarMensaje(batch,"Arturo Amador Sniper Developer",Pantalla.ANCHO/2,Pantalla.ALTO/2.1f);

        ecenaAyuda.draw();

        batch.end();

        batch.begin();

        texto.mostrarMensaje(batch,"Rodrigo Narvaez",Pantalla.ANCHO/2,Pantalla.ALTO/1.5f);
        texto.mostrarMensaje(batch,"Monse Designer",Pantalla.ANCHO/2,Pantalla.ALTO/1.7f);
        texto.mostrarMensaje(batch,"Alexis",Pantalla.ANCHO/2,Pantalla.ALTO/1.9f);
        texto.mostrarMensaje(batch,"Arturo Amador Sniper Developer",Pantalla.ANCHO/2,Pantalla.ALTO/2.1f);


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
