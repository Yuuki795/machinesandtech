package yuuki.machinesandtech.redstoneflux.api;

import org.bukkit.block.BlockFace;


public interface IEnergyConnection {
        /**
         * Returns TRUE if the TileEntity can connect on a given side.
         */
        boolean canConnectEnergy(BlockFace from);
        }
