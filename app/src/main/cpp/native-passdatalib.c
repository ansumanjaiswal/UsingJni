#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_example_jaisw_usingjni_MainActivity_getStringFromJNI( JNIEnv* env,
                                                               jobject thiz
                                                                )
{
#define hello "Hello Java "

    return (*env)->NewStringUTF(env, "Data from jni " hello);
}
