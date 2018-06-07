/*
 *  Copyright (c) Microsoft. All rights reserved.
 *  Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */

package com.microsoft.azure.sdk.iot.provisioning.service.configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Feature flag for if a provisioned device will be an edge device or not
 */
public class DeviceCapabilities
{
    // the is bulk operation success
    private static final String IOT_EDGE_TAG = "iotEdge";
    @Expose(serialize = true, deserialize = true)
    @SerializedName(IOT_EDGE_TAG)
    private boolean iotEdge;

    public DeviceCapabilities(boolean iotEdge)
    {
        // Codes_SRS_DEVICE_CAPABILITIES_34_001: [The constructor shall save the provided iotEdge flag.]
        this.iotEdge = iotEdge;
    }

    public DeviceCapabilities(String json)
    {
        // Codes_SRS_DEVICE_CAPABILITIES_34_002: [The constructor shall return the DeviceCapabilities object that is created when parsing the provided json.]
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().disableHtmlEscaping().create();
        DeviceCapabilities result = gson.fromJson(json, DeviceCapabilities.class);

        this.iotEdge = result.isIotEdge();
    }

    public boolean isIotEdge()
    {
        // Codes_SRS_DEVICE_CAPABILITIES_34_003: [This function shall return the saved value for the field iotEdge.]
        return this.iotEdge;
    }

    //empty constructor for Gson
    public DeviceCapabilities()
    {
        this.iotEdge = false;
    }
}
