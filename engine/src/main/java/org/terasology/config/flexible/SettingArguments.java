/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.config.flexible;

import org.terasology.config.flexible.constraints.SettingConstraint;
import org.terasology.config.flexible.internal.SettingBuilder;
import org.terasology.reflection.TypeInfo;

public final class SettingArguments {
    public static <V> SettingArgument<V, V> defaultValue(V defaultValue) {
        // TODO: Add null checks
        return new SettingArgument<>(defaultValue, SettingBuilder::defaultValue);
    }

    public static <V> SettingArgument<TypeInfo<V>, V> valueType(Class<V> valueClass) {
        return valueType(TypeInfo.of(valueClass));
    }

    public static <V> SettingArgument<TypeInfo<V>, V> valueType(TypeInfo<V> valueType) {
        return new SettingArgument<>(valueType, SettingBuilder::valueType);
    }

    public static <V> SettingArgument<SettingConstraint<V>, V> constraint(SettingConstraint<V> constraint) {
        return new SettingArgument<>(constraint, SettingBuilder::constraint);
    }

    public static <V> SettingArgument<String, V> humanReadableName(String humanReadableName) {
        return new SettingArgument<>(humanReadableName, SettingBuilder::humanReadableName);
    }

    public static <V> SettingArgument<String, V> description(String description) {
        return new SettingArgument<>(description, SettingBuilder::description);
    }
}
