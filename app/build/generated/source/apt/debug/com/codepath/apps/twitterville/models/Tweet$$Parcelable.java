
package com.codepath.apps.twitterville.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2016-08-14T18:37-0700")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Tweet$$Parcelable
    implements Parcelable, ParcelWrapper<com.codepath.apps.twitterville.models.Tweet>
{

    private com.codepath.apps.twitterville.models.Tweet tweet$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Tweet$$Parcelable.Creator$$1 CREATOR = new Tweet$$Parcelable.Creator$$1();

    public Tweet$$Parcelable(com.codepath.apps.twitterville.models.Tweet tweet$$2) {
        tweet$$0 = tweet$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(tweet$$0, parcel$$0, flags, new HashSet<Integer>());
    }

    public static void write(com.codepath.apps.twitterville.models.Tweet tweet$$1, android.os.Parcel parcel$$1, int flags$$0, Set<Integer> identitySet$$0) {
        int identity$$0 = System.identityHashCode(tweet$$1);
        parcel$$1 .writeInt(identity$$0);
        if (!identitySet$$0 .contains(identity$$0)) {
            identitySet$$0 .add(identity$$0);
            if (tweet$$1 == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(1);
                if (tweet$$1 .uid == null) {
                    parcel$$1 .writeInt(-1);
                } else {
                    parcel$$1 .writeInt(1);
                    parcel$$1 .writeLong(tweet$$1 .uid);
                }
                parcel$$1 .writeString(tweet$$1 .createdAt);
                if (tweet$$1 .user_id == null) {
                    parcel$$1 .writeInt(-1);
                } else {
                    parcel$$1 .writeInt(1);
                    parcel$$1 .writeLong(tweet$$1 .user_id);
                }
                parcel$$1 .writeString(tweet$$1 .body);
                com.codepath.apps.twitterville.models.User$$Parcelable.write(tweet$$1 .user, parcel$$1, flags$$0, identitySet$$0);
            }
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.codepath.apps.twitterville.models.Tweet getParcel() {
        return tweet$$0;
    }

    public static com.codepath.apps.twitterville.models.Tweet read(android.os.Parcel parcel$$3, Map<Integer, Object> identityMap$$0) {
        com.codepath.apps.twitterville.models.Tweet tweet$$3;
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$0 .containsKey(identity$$1)) {
            com.codepath.apps.twitterville.models.Tweet tweet$$4 = ((com.codepath.apps.twitterville.models.Tweet) identityMap$$0 .get(identity$$1));
            if ((tweet$$4 == null)&&(identity$$1 != 0)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return tweet$$4;
        }
        if (parcel$$3 .readInt() == -1) {
            tweet$$3 = null;
            identityMap$$0 .put(identity$$1, null);
        } else {
            com.codepath.apps.twitterville.models.Tweet tweet$$5;
            identityMap$$0 .put(identity$$1, null);
            tweet$$5 = new com.codepath.apps.twitterville.models.Tweet();
            identityMap$$0 .put(identity$$1, tweet$$5);
            int int$$0 = parcel$$3 .readInt();
            java.lang.Long long$$0;
            if (int$$0 < 0) {
                long$$0 = null;
            } else {
                long$$0 = parcel$$3 .readLong();
            }
            tweet$$5 .uid = long$$0;
            tweet$$5 .createdAt = parcel$$3 .readString();
            int int$$1 = parcel$$3 .readInt();
            java.lang.Long long$$1;
            if (int$$1 < 0) {
                long$$1 = null;
            } else {
                long$$1 = parcel$$3 .readLong();
            }
            tweet$$5 .user_id = long$$1;
            tweet$$5 .body = parcel$$3 .readString();
            User user$$0 = com.codepath.apps.twitterville.models.User$$Parcelable.read(parcel$$3, identityMap$$0);
            tweet$$5 .user = user$$0;
            tweet$$3 = tweet$$5;
        }
        return tweet$$3;
    }

    public final static class Creator$$1
        implements Creator<Tweet$$Parcelable>
    {


        @Override
        public Tweet$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Tweet$$Parcelable(read(parcel$$2, new HashMap<Integer, Object>()));
        }

        @Override
        public Tweet$$Parcelable[] newArray(int size) {
            return new Tweet$$Parcelable[size] ;
        }

    }

}
