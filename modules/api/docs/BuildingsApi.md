# BuildingsApi

All URIs are relative to *http://fal-1.upcode-dev.at:8001/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**buildingsCreate**](BuildingsApi.md#buildingsCreate) | **POST** /buildings/ | 
[**buildingsDelete**](BuildingsApi.md#buildingsDelete) | **DELETE** /buildings/{id}/ | 
[**buildingsList**](BuildingsApi.md#buildingsList) | **GET** /buildings/ | 
[**buildingsPartialUpdate**](BuildingsApi.md#buildingsPartialUpdate) | **PATCH** /buildings/{id}/ | 
[**buildingsRead**](BuildingsApi.md#buildingsRead) | **GET** /buildings/{id}/ | 
[**buildingsSaveSelectedCreate**](BuildingsApi.md#buildingsSaveSelectedCreate) | **POST** /buildings/save_selected/ | 
[**buildingsSearchList**](BuildingsApi.md#buildingsSearchList) | **GET** /buildings/search/ | 
[**buildingsSlimList**](BuildingsApi.md#buildingsSlimList) | **GET** /buildings/slim/ | 
[**buildingsUpdate**](BuildingsApi.md#buildingsUpdate) | **PUT** /buildings/{id}/ | 
[**buildingsYearRead**](BuildingsApi.md#buildingsYearRead) | **GET** /buildings/year/{year}/ | 


<a name="buildingsCreate"></a>
# **buildingsCreate**
> Building buildingsCreate(data)



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    Building data = new Building(); // Building | 
    try {
      Building result = apiInstance.buildingsCreate(data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsCreate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Building**](Building.md)|  |

### Return type

[**Building**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** |  |  -  |

<a name="buildingsDelete"></a>
# **buildingsDelete**
> buildingsDelete(id)



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      apiInstance.buildingsDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** |  |  -  |

<a name="buildingsList"></a>
# **buildingsList**
> List&lt;Building&gt; buildingsList()



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    try {
      List<Building> result = apiInstance.buildingsList();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Building&gt;**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsPartialUpdate"></a>
# **buildingsPartialUpdate**
> Building buildingsPartialUpdate(id, data)



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String id = "id_example"; // String | 
    Building data = new Building(); // Building | 
    try {
      Building result = apiInstance.buildingsPartialUpdate(id, data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsPartialUpdate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Building**](Building.md)|  |

### Return type

[**Building**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsRead"></a>
# **buildingsRead**
> Building buildingsRead(id)



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Building result = apiInstance.buildingsRead(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsRead");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**Building**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsSaveSelectedCreate"></a>
# **buildingsSaveSelectedCreate**
> buildingsSaveSelectedCreate()



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    try {
      apiInstance.buildingsSaveSelectedCreate();
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsSaveSelectedCreate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** |  |  -  |

<a name="buildingsSearchList"></a>
# **buildingsSearchList**
> buildingsSearchList(address)



API endpoint that allows users to search for buildings by address.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String address = "address_example"; // String | Partial or full address to search for
    try {
      apiInstance.buildingsSearchList(address);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsSearchList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **String**| Partial or full address to search for | [optional]

### Return type

null (empty response body)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsSlimList"></a>
# **buildingsSlimList**
> List&lt;Building&gt; buildingsSlimList(lat, lon, century, addressOrName)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    BigDecimal lat = new BigDecimal(78); // BigDecimal | Latitude of the location.
    BigDecimal lon = new BigDecimal(78); // BigDecimal | Longitude of the location
    Integer century = 56; // Integer | Century of the building's construction (e.g., 20 for 20th Century).
    String addressOrName = "addressOrName_example"; // String | Partial or full address or name of the
    try {
      List<Building> result = apiInstance.buildingsSlimList(lat, lon, century, addressOrName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsSlimList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lat** | **BigDecimal**| Latitude of the location. | [optional]
 **lon** | **BigDecimal**| Longitude of the location | [optional]
 **century** | **Integer**| Century of the building&#39;s construction (e.g., 20 for 20th Century). | [optional]
 **addressOrName** | **String**| Partial or full address or name of the | [optional]

### Return type

[**List&lt;Building&gt;**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsUpdate"></a>
# **buildingsUpdate**
> Building buildingsUpdate(id, data)



A simple ViewSet for viewing and editing buildings.

### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String id = "id_example"; // String | 
    Building data = new Building(); // Building | 
    try {
      Building result = apiInstance.buildingsUpdate(id, data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsUpdate");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **data** | [**Building**](Building.md)|  |

### Return type

[**Building**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="buildingsYearRead"></a>
# **buildingsYearRead**
> List&lt;Building&gt; buildingsYearRead(year)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.BuildingsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    BuildingsApi apiInstance = new BuildingsApi(defaultClient);
    String year = "year_example"; // String | 
    try {
      List<Building> result = apiInstance.buildingsYearRead(year);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BuildingsApi#buildingsYearRead");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **year** | **String**|  |

### Return type

[**List&lt;Building&gt;**](Building.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

