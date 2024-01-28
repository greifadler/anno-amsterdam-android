

# Building


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**location** | [**Location**](Location.md) |  | 
**createdAt** | **OffsetDateTime** | The date and time this record was created. Automatically set upon creation. |  [optional] [readonly]
**updatedAt** | **OffsetDateTime** | The date and time this record was last updated. Automatically updated on save. |  [optional] [readonly]
**mainImageUrl** | **String** | URL to a preview image of the building. | 
**address** | **String** | Physical address of the building. | 
**name** | **String** | Alternative name instead of the address of the building. |  [optional]
**constructionYear** | **Integer** | Year when the building was constructed. | 
**typeOfUse** | **String** | The intended use of the building (e.g., residential, commercial). | 
**tags** | **List&lt;String&gt;** | JSON-formatted list of tags related to the building. |  [optional]
**description** | **String** | Detailed description of the building. |  [optional]
**imageUrls** | [**List&lt;BuildingImageUrls&gt;**](BuildingImageUrls.md) | JSON-formatted list of objects with URLs to images of the building and their sources. |  [optional]
**timeline** | [**List&lt;BuildingTimeline&gt;**](BuildingTimeline.md) | JSON-formatted data representing key events in the building&#39;s history. |  [optional]
**active** | **Boolean** | Indicates whether the building is active or not. |  [optional]
**audioguides** | **Object** | JSON-formatted list of audioguides. |  [optional]



