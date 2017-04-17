#include <jni.h>
JNIEXPORT jint JNICALL
Java_com_example_jaisw_usingjni_MainActivity_getIntFromJNI( JNIEnv* env,
                                                               jobject thiz,
                                                               jint a,
                                                               jint b
)
{

    return a+b;
}
