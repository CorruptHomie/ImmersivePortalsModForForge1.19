package qouteall.imm_ptl.core.platform_specific;

import qouteall.imm_ptl.core.Helper;
import qouteall.imm_ptl.core.ModMain;
import qouteall.imm_ptl.core.PehkuiInterface;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class ModEntry implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ModMain.init();
        RequiemCompat.init();
        
        MyRegistry.registerEntitiesFabric();
        
        MyRegistry.registerMyDimensionsFabric();
        
        MyRegistry.registerBlocksFabric();
        
        MyRegistry.registerChunkGenerators();
        
        O_O.isReachEntityAttributesPresent =
            FabricLoader.getInstance().isModLoaded("reach-entity-attributes");
        if (O_O.isReachEntityAttributesPresent) {
            Helper.log("Reach entity attributes mod is present");
        }
        else {
            Helper.log("Reach entity attributes mod is not present");
        }
        
        PehkuiInterface.isPehkuiPresent =
            O_O.getIsPehkuiPresent();
        if (PehkuiInterface.isPehkuiPresent) {
            PehkuiInterfaceInitializer.init();
            Helper.log("Pehkui is present");
        }
        else {
            Helper.log("Pehkui is not present");
        }
        
        
    }
    
}