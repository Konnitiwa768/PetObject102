package:com.sakaltj.petobject
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
    public static final EntityType<CocleaEntity> COCLEA = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("petobject2", "coclea"),
        EntityType.Builder.create(CocleaEntity::new, SpawnGroup.CREATURE)
            .setDimensions(0.6f, 1.2f)
            .build("coclea")
    );

    public static void registerAttributes() {
        net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(COCLEA, CocleaEntity.createCocleaAttributes());
    }
}
