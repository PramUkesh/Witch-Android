package se.snylt.witch.processor.viewbinder.isdirty;


import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

public class IsDirtyAlways extends IsDirty {

    public IsDirtyAlways(TypeName targetTypeName) {
        super(targetTypeName);
    }

    @Override
    MethodSpec.Builder addReturnStatement(MethodSpec.Builder builder) {
        return builder.addStatement("return true");
    }
}
