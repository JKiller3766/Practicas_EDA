package registers;

import dogs.Dog;
import dogs.DogID;
import dogs.DogPurpose;

import java.lang.classfile.Interfaces;
import java.util.LinkedHashMap;
import java.util.SortedSet;

public class DogRegisterImp implements  DogRegister{
    interface MapDogs<K,V>{
    }
    private LinkedHashMap<String,Dog> MapDogs;
    @Override
    public boolean registerOwner(String owner) {

    if(!MapDogs.containsKey(owner)) {
        MapDogs.put(owner, null);
        return true;
    }

    return false;

    }

    @Override
    public boolean registerDog(String owner, Dog dog) {

    if(!MapDogs.containsKey(owner)) {
        throw new UnknownOwnerException("Owner not found");
    }

    if(MapDogs.get(owner) == dog){
        return false;
    }

    if(MapDogs.containsValue(dog)) {
        throw new DifferentOwnerException();
    }

    MapDogs.put(owner,dog);
    return true;

    }

    @Override
    public String findOwner(DogID id) {
        Dog dog;
        for (String owner : MapDogs.keySet()) {
            dog = MapDogs.get(owner);
            if (dog.getId().equals(id)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public SortedSet<Dog> registeredDogs(String owner) {

        SortedSet<Dog> dogs = null;

        for (String currentOwner : MapDogs.keySet()) {
            if (currentOwner.equals(owner)) {
                dogs.add(MapDogs.get(currentOwner));
            }
        }

        return dogs;

    }

    @Override
    public SortedSet<String> findPurposeOwners(DogPurpose purpose) {
        SortedSet<String> owners = null;
        for (Dog currentDog : MapDogs.values()) {
            if (currentDog.getType().equals(purpose)) {
                owners.add(findOwner(currentDog.getId()));
            }
        }
        return owners;
    }
}
