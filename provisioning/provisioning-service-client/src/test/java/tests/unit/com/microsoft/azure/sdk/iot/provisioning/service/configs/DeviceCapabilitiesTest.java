/*
 *  Copyright (c) Microsoft. All rights reserved.
 *  Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */

package tests.unit.com.microsoft.azure.sdk.iot.provisioning.service.configs;

import com.microsoft.azure.sdk.iot.provisioning.service.configs.DeviceCapabilities;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DeviceCapabilitiesTest
{
    // Tests_SRS_DEVICE_CAPABILITIES_34_001: [The constructor shall save the provided iotEdge flag.]
    @Test
    public void constuctorSavesIotEdgeFlag()
    {
        //act
        DeviceCapabilities capabilities = new DeviceCapabilities(true);

        //assert
        assertTrue(capabilities.isIotEdge());
    }

    // Tests_SRS_DEVICE_CAPABILITIES_34_002: [The constructor shall return the DeviceCapabilities object that is created when parsing the provided json.]
    @Test
    public void constructorWithJsonSuccess()
    {
        //arrange
        String json =
                    "{\n" +
                        "\"iotEdge\": \"true\"\n" +
                    "}";

        //act
        DeviceCapabilities capabilities = new DeviceCapabilities(json);

        //assert
        assertTrue(capabilities.isIotEdge());
    }

    // Tests_SRS_DEVICE_CAPABILITIES_34_003: [This function shall return the saved value for the field iotEdge.]
    @Test
    public void isIotEdgeSuccess()
    {
        //arrange
        DeviceCapabilities capabilities = new DeviceCapabilities(true);

        //act/assert
        assertTrue(capabilities.isIotEdge());
    }

}
