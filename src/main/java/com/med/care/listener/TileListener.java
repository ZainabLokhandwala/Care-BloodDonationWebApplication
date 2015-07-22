package com.med.care.listener;


import com.med.care.tiles.TileInitializer;
import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;

import javax.servlet.annotation.WebListener;

@WebListener
public class TileListener extends AbstractTilesListener{

    @Override
    protected TilesInitializer createTilesInitializer() {
        return new TileInitializer();
    }
}
