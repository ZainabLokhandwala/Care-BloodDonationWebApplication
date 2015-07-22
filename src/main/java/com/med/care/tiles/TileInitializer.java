package com.med.care.tiles;


import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;

import java.io.IOException;

public class TileInitializer extends AbstractTilesInitializer {
    @Override
    protected AbstractTilesContainerFactory createContainerFactory(TilesApplicationContext context) {
        return new BasicTilesContainerFactory();
    }
    
}
