/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int size = size();
        for(int i=0;i<size;i++){
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if(size()<=1000) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        int size = size();
        for(int i=0;i<size;i++){
            if(storage[i].uuid.equals(uuid)){ return storage[i];}
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();
        int k=0;
        boolean isFind=false;
        for(int i=0;i<size;i++){
            if(!isFind) {
                if (storage[i].uuid.equals(uuid)) {
                    isFind = true;
                    k = i;
                    if(i==size-1){storage[size-1] = null;}
                }
            }else{
                storage[k] = storage[i];
                if(i==size-1){storage[size-1] = null;}
                k++;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] r = new Resume[size];
        for(int i=0;i<size;i++){
            r[i]=storage[i];
        }
        return r;
    }

    int size() {
        int size = 0;
        for(int i=0;i<10000;i++){
            if(storage[i] == null){
                break;
            }
            size++;
        }
        return size;
    }
}
