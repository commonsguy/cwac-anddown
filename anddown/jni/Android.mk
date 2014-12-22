# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#LOCAL_PATH := $(call my-dir)

#include $(CLEAR_VARS)

#LOCAL_MODULE    := anddown
#LOCAL_SRC_FILES := anddown.c autolink.c buffer.c escape.c html.c html_blocks.c html_smartypants.c markdown.c stack.c
# LOCAL_C_INCLUDES := 

#include $(BUILD_SHARED_LIBRARY)

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := anddown
LOCAL_SRC_FILES := \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/autolink.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/Android.mk \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/Application.mk \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/html_blocks.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/html.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/buffer.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/stack.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/html_smartypants.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/markdown.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/escape.c \
	/home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni/anddown.c \

LOCAL_C_INCLUDES += /home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/jni
LOCAL_C_INCLUDES += /home/mmurphy/stuff/CommonsWare/projects/CWAC/AndDown/anddown/build-types/release/jni

include $(BUILD_SHARED_LIBRARY)

