package com.valterc.ki2.karoo.overlay.view.builder;

import com.valterc.ki2.R;
import com.valterc.ki2.karoo.overlay.view.compact.CompactDarkGearIndexOverlayView;
import com.valterc.ki2.karoo.overlay.view.compact.CompactDarkGearSizeOverlayView;
import com.valterc.ki2.karoo.overlay.view.compact.CompactDarkGearSizeRatioOverlayView;
import com.valterc.ki2.karoo.overlay.view.compact.CompactLightGearIndexOverlayView;
import com.valterc.ki2.karoo.overlay.view.compact.CompactLightGearSizeOverlayView;
import com.valterc.ki2.karoo.overlay.view.compact.CompactLightGearSizeRatioOverlayView;
import com.valterc.ki2.karoo.overlay.view.plain.DefaultDarkGearIndexOverlayView;
import com.valterc.ki2.karoo.overlay.view.plain.DefaultDarkGearSizeRatioOverlayView;
import com.valterc.ki2.karoo.overlay.view.plain.DefaultLightGearIndexOverlayView;
import com.valterc.ki2.karoo.overlay.view.plain.DefaultLightGearSizeRatioOverlayView;
import com.valterc.ki2.karoo.overlay.view.simple.SimpleDarkOverlayView;
import com.valterc.ki2.karoo.overlay.view.simple.SimpleLightOverlayView;

import java.util.HashMap;

public final class OverlayViewBuilderRegistry {

    private OverlayViewBuilderRegistry() {
    }

    private static final HashMap<String, OverlayViewBuilderEntry> builderMap = new HashMap<>();

    static {
        builderMap.put("default_dark_gear_index", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, DefaultDarkGearIndexOverlayView::new));
        builderMap.put("default_light_gear_index", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, DefaultLightGearIndexOverlayView::new));
        builderMap.put("default_dark_gear_size_ratio", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, DefaultDarkGearSizeRatioOverlayView::new));
        builderMap.put("default_light_gear_size_ratio", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, DefaultLightGearSizeRatioOverlayView::new));
        builderMap.put("simple_dark", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, SimpleDarkOverlayView::new));
        builderMap.put("simple_light", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay, SimpleLightOverlayView::new));
        builderMap.put("compact_dark_gear_index", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactDarkGearIndexOverlayView::new));
        builderMap.put("compact_light_gear_index", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactLightGearIndexOverlayView::new));
        builderMap.put("compact_dark_gear_size", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactDarkGearSizeOverlayView::new));
        builderMap.put("compact_light_gear_size", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactLightGearSizeOverlayView::new));
        builderMap.put("compact_dark_gear_size_ratio", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactDarkGearSizeRatioOverlayView::new));
        builderMap.put("compact_light_gear_size_ratio", new OverlayViewBuilderEntry(R.layout.view_karoo_overlay_compact, CompactLightGearSizeRatioOverlayView::new));
    }

    public static OverlayViewBuilderEntry getBuilder(String key) {
        return builderMap.get(key);
    }

}
