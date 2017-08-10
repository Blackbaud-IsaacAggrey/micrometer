/**
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.core.instrument.util;

import io.micrometer.core.instrument.Meter;

/**
 * @author Jon Schneider
 */
public final class Meters {
    private Meters() {}

    public static boolean equals(Meter m1, Object o) {
        if (m1 == null && o != null) return false;
        if (o == null && m1 != null) return false;
        if (!(o instanceof Meter)) return false;
        if (m1 == o) return true;
        Meter m2 = (Meter) o;
        return (m1.getName() != null ? m1.getName().equals(m2.getName()) : m2.getName() == null) &&
                (m1.getTags() != null ? m1.getTags().equals(m2.getTags()) : m2.getTags() == null) &&
                (m1.getType() != null ? m1.getType().equals(m2.getType()) : m2.getType() == null);
    }

    public static int hashCode(Meter m) {
        int result = m.getName() != null ? m.getName().hashCode() : 0;
        result = 31 * result + (m.getTags() != null ? m.getTags().hashCode() : 0);
        result = 31 * result + (m.getType() != null ? m.getType().hashCode() : 0);
        return result;
    }
}
