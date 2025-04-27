package registers;

import dogs.Dog;
import dogs.DogID;
import dogs.DogPurpose;

import java.lang.classfile.Interfaces;
import java.util.LinkedHashMap;
import java.util.SortedSet;

public class DogRegisterImp implements  DogRegister{
    private LinkedHashMap<String,Dog> MapDogs = new LinkedHashMap<>();
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
        for (String currentOwner : MapDogs.keySet()) {
            for (Dog currentDog : MapDogs.values()){
                if(currentDog.getId().equals(id)){
                    return currentOwner;
                }
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
