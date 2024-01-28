# AudioguidesApi

All URIs are relative to *http://fal-1.upcode-dev.at:8001/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**audioguidesCreate**](AudioguidesApi.md#audioguidesCreate) | **POST** /audioguides/ | 
[**audioguidesDelete**](AudioguidesApi.md#audioguidesDelete) | **DELETE** /audioguides/{id}/ | 
[**audioguidesList**](AudioguidesApi.md#audioguidesList) | **GET** /audioguides/ | 
[**audioguidesPartialUpdate**](AudioguidesApi.md#audioguidesPartialUpdate) | **PATCH** /audioguides/{id}/ | 
[**audioguidesRead**](AudioguidesApi.md#audioguidesRead) | **GET** /audioguides/{id}/ | 
[**audioguidesUpdate**](AudioguidesApi.md#audioguidesUpdate) | **PUT** /audioguides/{id}/ | 


<a name="audioguidesCreate"></a>
# **audioguidesCreate**
> Audioguide audioguidesCreate(data)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    Audioguide data = new Audioguide(); // Audioguide | 
    try {
      Audioguide result = apiInstance.audioguidesCreate(data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesCreate");
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
 **data** | [**Audioguide**](Audioguide.md)|  |

### Return type

[**Audioguide**](Audioguide.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** |  |  -  |

<a name="audioguidesDelete"></a>
# **audioguidesDelete**
> audioguidesDelete(id)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      apiInstance.audioguidesDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesDelete");
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

<a name="audioguidesList"></a>
# **audioguidesList**
> List&lt;Audioguide&gt; audioguidesList()



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    try {
      List<Audioguide> result = apiInstance.audioguidesList();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesList");
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

[**List&lt;Audioguide&gt;**](Audioguide.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="audioguidesPartialUpdate"></a>
# **audioguidesPartialUpdate**
> Audioguide audioguidesPartialUpdate(id, data)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    String id = "id_example"; // String | 
    Audioguide data = new Audioguide(); // Audioguide | 
    try {
      Audioguide result = apiInstance.audioguidesPartialUpdate(id, data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesPartialUpdate");
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
 **data** | [**Audioguide**](Audioguide.md)|  |

### Return type

[**Audioguide**](Audioguide.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="audioguidesRead"></a>
# **audioguidesRead**
> Audioguide audioguidesRead(id)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Audioguide result = apiInstance.audioguidesRead(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesRead");
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

[**Audioguide**](Audioguide.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

<a name="audioguidesUpdate"></a>
# **audioguidesUpdate**
> Audioguide audioguidesUpdate(id, data)



### Example
```java
// Import classes:
import nl.anno.amsterdam.ApiClient;
import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.Configuration;
import nl.anno.amsterdam.auth.*;
import nl.anno.amsterdam.models.*;
import nl.anno.amsterdam.api.AudioguidesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://fal-1.upcode-dev.at:8001/api");
    
    // Configure HTTP basic authorization: Basic
    HttpBasicAuth Basic = (HttpBasicAuth) defaultClient.getAuthentication("Basic");
    Basic.setUsername("YOUR USERNAME");
    Basic.setPassword("YOUR PASSWORD");

    AudioguidesApi apiInstance = new AudioguidesApi(defaultClient);
    String id = "id_example"; // String | 
    Audioguide data = new Audioguide(); // Audioguide | 
    try {
      Audioguide result = apiInstance.audioguidesUpdate(id, data);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AudioguidesApi#audioguidesUpdate");
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
 **data** | [**Audioguide**](Audioguide.md)|  |

### Return type

[**Audioguide**](Audioguide.md)

### Authorization

[Basic](../README.md#Basic)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |

