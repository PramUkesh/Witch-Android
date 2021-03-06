package se.snylt.witch.processor.viewbinder.newinstance;

import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

import se.snylt.witch.processor.utils.TypeUtils;
import se.snylt.witch.processor.viewbinder.TypeSpecModule;

import static se.snylt.witch.processor.utils.TypeUtils.VIEW_BINDER;


public class NewViewBinderInstance implements TypeSpecModule {

    private final int viewId;

    private final TypeName viewTypeName;

    private final TypeName viewHolderTypeName;

    private final TypeName targetTypeName;

    private final TypeName valueTypeName;

    public NewViewBinderInstance(int viewId, TypeName viewTypeName, TypeName viewHolderTypeName,
            TypeName targetTypeName, TypeName valueTypeName) {
        this.viewId = viewId;
        this.viewTypeName = viewTypeName;
        this.viewHolderTypeName = viewHolderTypeName;
        this.targetTypeName = targetTypeName;
        this.valueTypeName = valueTypeName;
    }

    @Override
    public TypeSpec.Builder builder() {
        return TypeSpec.anonymousClassBuilder("$L", viewId)
                .addSuperinterface(ParameterizedTypeName.get(VIEW_BINDER, targetTypeName, viewTypeName, valueTypeName, viewHolderTypeName))
                .addField(TypeUtils.BINDER, "binder", Modifier.PROTECTED);

    }
}
