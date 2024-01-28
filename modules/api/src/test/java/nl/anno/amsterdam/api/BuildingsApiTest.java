/*
 * Anno Amsterdam CoreAPI
 * The internal API for the Anno Amsterdam project's CMS
 *
 * The version of the OpenAPI document: v1
 * Contact: preis@computer.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package nl.anno.amsterdam.api;

import nl.anno.amsterdam.ApiException;
import nl.anno.amsterdam.model.Building;
import java.util.UUID;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BuildingsApi
 */
@Ignore
public class BuildingsApiTest {

    private final BuildingsApi api = new BuildingsApi();

    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsCreateTest() throws ApiException {
        Building data = null;
                Building response = api.buildingsCreate(data);
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsDeleteTest() throws ApiException {
        UUID id = null;
                api.buildingsDelete(id);
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsListTest() throws ApiException {
                List<Building> response = api.buildingsList();
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsPartialUpdateTest() throws ApiException {
        UUID id = null;
        Building data = null;
                Building response = api.buildingsPartialUpdate(id, data);
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsReadTest() throws ApiException {
        UUID id = null;
                Building response = api.buildingsRead(id);
        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void buildingsUpdateTest() throws ApiException {
        UUID id = null;
        Building data = null;
                Building response = api.buildingsUpdate(id, data);
        // TODO: test validations
    }
    
}