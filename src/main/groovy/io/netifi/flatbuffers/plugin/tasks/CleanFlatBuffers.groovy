/*
 * Copyright 2017 Netifi Inc.
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

package io.netifi.flatbuffers.plugin.tasks

import io.netifi.flatbuffers.plugin.FlatBuffersPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class CleanFlatBuffers extends DefaultTask {

    private File outputDir

    @TaskAction
    void run() {
        if (outputDir) {
            if (outputDir.exists()) {
                getLogger().debug("Cleaning output directory '{}'.", outputDir.absolutePath)
                outputDir.deleteDir()
            }
        } else {
            getLogger().debug("Skipping clean of output directory '{}' as it does not exist.", outputDir.absolutePath)
        }
    }

    @Internal
    @Override
    String getGroup() {
        return FlatBuffersPlugin.GROUP
    }

    @Internal
    @Override
    String getDescription() {
        return 'Deletes the FlatBuffers build directory.'
    }

    @OutputDirectory
    File getOutputDir() {
        return outputDir
    }

    void setOutputDir(File outputDir) {
        this.outputDir = outputDir
    }

}
