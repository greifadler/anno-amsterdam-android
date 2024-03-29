package nl.anno.amsterdam.ui.map

import com.google.android.gms.maps.model.MapStyleOptions

val annoMapStyleOptions = MapStyleOptions("[\n" +
        "  {\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#ebe3cd\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#523735\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"elementType\": \"labels.text.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#f5f1e6\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"administrative\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"visibility\": \"off\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"administrative\",\n" +
        "    \"elementType\": \"geometry.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#c9b2a6\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"administrative.land_parcel\",\n" +
        "    \"elementType\": \"geometry.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#dcd2be\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"administrative.land_parcel\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#ae9e90\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"landscape.natural\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#dfd2ae\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"poi\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"visibility\": \"off\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"poi\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#dfd2ae\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"poi\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#93817c\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"poi.park\",\n" +
        "    \"elementType\": \"geometry.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#a5b076\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"poi.park\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#447530\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#f5f1e6\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road\",\n" +
        "    \"elementType\": \"labels.icon\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"visibility\": \"off\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.arterial\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#fdfcf8\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.highway\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#f8c967\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.highway\",\n" +
        "    \"elementType\": \"geometry.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#e9bc62\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.highway.controlled_access\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#e98d58\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.highway.controlled_access\",\n" +
        "    \"elementType\": \"geometry.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#db8555\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"road.local\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#806b63\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"transit\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"visibility\": \"off\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"transit.line\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#dfd2ae\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"transit.line\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#8f7d77\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"transit.line\",\n" +
        "    \"elementType\": \"labels.text.stroke\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#ebe3cd\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"transit.station\",\n" +
        "    \"elementType\": \"geometry\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#dfd2ae\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"water\",\n" +
        "    \"elementType\": \"geometry.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#b9d3c2\"\n" +
        "      }\n" +
        "    ]\n" +
        "  },\n" +
        "  {\n" +
        "    \"featureType\": \"water\",\n" +
        "    \"elementType\": \"labels.text.fill\",\n" +
        "    \"stylers\": [\n" +
        "      {\n" +
        "        \"color\": \"#92998d\"\n" +
        "      }\n" +
        "    ]\n" +
        "  }\n" +
        "]")