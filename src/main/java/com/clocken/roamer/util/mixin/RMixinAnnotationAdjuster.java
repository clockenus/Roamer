package com.clocken.roamer.util.mixin;

import com.bawnorton.mixinsquared.adjuster.tools.AdjustableAnnotationNode;
import com.bawnorton.mixinsquared.api.MixinAnnotationAdjuster;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.List;

public class RMixinAnnotationAdjuster implements MixinAnnotationAdjuster {

    @Override
    public AdjustableAnnotationNode adjust(List<String> targetClassNames, String mixinClassName, MethodNode method, AdjustableAnnotationNode annotation) {
        List<Injection> INJECTIONS = new ArrayList<>(List.of(
                // horseman
//                new Injection("AbstractHorseMixin", "onMobInteract")
        ));

        // mixin canceling
        for (Injection injection : INJECTIONS) {
            if (mixinClassName.equals(injection.mixinClassName) && method.name.equals(injection.method)) {
                return null;
            }
        }
        return annotation;
    }
}