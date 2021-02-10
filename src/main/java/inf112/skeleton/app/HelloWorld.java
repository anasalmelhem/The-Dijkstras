package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

public class HelloWorld implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private TiledMap map;
    private TiledMapTileLayer boardLayer, playerLayer, holeLayer, flagLayer;
    private OrthogonalTiledMapRenderer myRenderer;
    private OrthographicCamera myCam;


    public TiledMap map;
    private TiledMapTileLayer Board;
    private TiledMapTileLayer Player;
    private TiledMapTileLayer Hole;
    private TiledMapTileLayer Flag;

    public OrthoCachedTiledMapRenderer orthoRenderer;
    public OrthographicCamera camera;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        map = new TmxMapLoader().load("assets/exampleMap.tmx");
        boardLayer= (TiledMapTileLayer) map.getLayers().get("Board");
        playerLayer= (TiledMapTileLayer) map.getLayers().get("Player");
        holeLayer= (TiledMapTileLayer) map.getLayers().get("Hole");
        flagLayer= (TiledMapTileLayer) map.getLayers().get("Flag");
        font.setColor(Color.RED);
 
        myCam = new OrthographicCamera();
        myCam.setToOrtho(false,5,5);
        myCam.position.set(2.5F, 5.0F, 0.0F);
        myCam.update();
        myRenderer= new OrthogonalTiledMapRenderer(map,1F/300F);
        myRenderer.setView(myCam);

        TiledMap map = new TmxMapLoader().load("assets/exampleMap.tmx");
        TiledMapTileLayer Board = (TiledMapTileLayer) map.getLayers().get("Board");
        TiledMapTileLayer Flag = (TiledMapTileLayer) map.getLayers().get("Flag");
        TiledMapTileLayer Hole = (TiledMapTileLayer) map.getLayers().get("Hole");
        TiledMapTileLayer Player = (TiledMapTileLayer) map.getLayers().get("Player");
        camera = new OrthographicCamera(500, 500);
        camera.setToOrtho(false, 5, 5);
        camera.position.set(2.5f, 2.5f,0f);
        camera.update();
        orthoRenderer = new OrthoCachedTiledMapRenderer(map, (1/300f));

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);


        myRenderer.render();

        batch.begin();
        font.draw(batch, "Robo Rally", 200, 200);
        orthoRenderer.setView(camera);
        orthoRenderer.render();
        batch.end();

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
}
