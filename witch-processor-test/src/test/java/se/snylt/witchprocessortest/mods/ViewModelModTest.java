package se.snylt.witchprocessortest.mods;


import java.util.List;

import se.snylt.witch.viewbinder.Binder;
import se.snylt.witch.viewbinder.ViewBinder;
import se.snylt.witchprocessortest.TestBase;

import static junit.framework.Assert.assertSame;

public class ViewModelModTest extends TestBase {

    @Override
    protected void testBind(List<ViewBinder> binder, Object viewHolder) {
        ViewModelMod mod = new ViewModelMod();
        assertSame(mod.something, binder.get(0).getModActions(mod));
    }

    @Override
    protected Object getViewHolder() {
        return new ModViewModel_ViewHolder();
    }

    @Override
    protected Binder getBinder() {
        return new ModViewModel_ViewBinder().createBinder();
    }
}