package mx.itesm.aap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Arturo on 08/09/17.
 */

class Personaje {

    private Texture textureNave;
    private float  x;
    private  float y;


    public Personaje(float x, float y){

        this.x = x;
        this.y = y;
        textureNave = new Texture("nave.png");

    }

    public void render(SpriteBatch batch){

        batch.draw(textureNave,x,y);

    }


    public void mover (float dx){
        x += dx;
    }
}
