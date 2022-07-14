package server;

import co.gongzh.procbridge.IDelegate;
import co.gongzh.procbridge.Server;
import org.jetbrains.annotations.Nullable;
import server.user.TutorialUser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class SocketServer {

    public static ArrayList<TutorialUser> users = new ArrayList<>();
    public static ArrayList<String> allUserss = new ArrayList<>();

    private static int count = -1;

    public static void main(String[] args) throws FileNotFoundException {
        Server server = new Server(8873, new IDelegate() {
            @Override
            public @Nullable Object handleRequest(@Nullable String method, @Nullable Object payload) {
                switch (method) {
                    case "echo":
                        System.out.println(method + " " + payload.toString());
                        return payload;
                    case "start_tutorial":
                        String[] userProperties = payload.toString().split(":");
//                        for(TutorialUser user : users) {
//                            allUserss.add(user.getMcName());
//                        }


                        if(!allUserss.contains(userProperties[0])) {
                            users.add(new TutorialUser(userProperties[0],
                                    Boolean.parseBoolean(userProperties[1]),
                                    Boolean.parseBoolean(userProperties[2]),
                                    Boolean.parseBoolean(userProperties[3]),
                                    Boolean.parseBoolean(userProperties[4])
                            ));
                            allUserss.add(userProperties[0]);
                            System.out.println(userProperties[2]);
                            count++;
                            System.out.println(users.size());
                            System.out.println(users.get(count).getProperties());
                            System.out.println(userProperties[0] + " Has Joined Minecraft & Connected To This Socket!");
                            return payload;
                        } else {
                            return payload;
                        }


                    case "stop_tutorial":
                        String[] userProperties1 = payload.toString().split(":");
                        for(int i = 0; i < users.size(); i++) {
                            if(users.get(i).getMcName().equals(userProperties1[0])) {
                                users.remove(users.get(i));
                                allUserss.remove(allUserss.get(i));
                                count--;
                                System.out.println(users.size());
                                System.out.println(userProperties1[0] + " Has Left Minecraft & The Socket");
                                return payload;

                            }
                        }
//                        for(TutorialUser user : users) {
//                            if(user.getMcName().equals(userProperties1[0])) {
//                                    users.remove(user);
//                                    allUserss.remove(userProperties1[0]);
//                                    count--;
//                                    System.out.println(users.size());
//                                    System.out.println(userProperties1[0] + " Has Left Minecraft & The Socket");
//                                    return payload;
//
//                            }
//                        }


                    case "isUser":
                        for(TutorialUser user : users) {
                            if(payload.toString().equals(user.getMcName())) {
                                return "true";
                            }
                        }
                        return "false";
                    case "userCount":
                        return users.size();
                    case "connectedUsers":
                        String allUsers = "";
                        for(TutorialUser user : users) {
                            allUsers += user.getMcName() + ",";
                        }
                        return allUsers;
                    case "isUsingWings":
                        for(TutorialUser user : users) {
                            if(payload.toString().equals(user.getMcName())) {
                                if(user.areWingsEnabled == true) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        }
                        return "false";
                    case "isUsingTophat":
                        for(TutorialUser user : users) {
                            if(payload.toString().equals(user.getMcName())) {
                                if(user.areTophatEnabled == true) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        }
                        return "false";
                    case "isUsingBandana":
                        for(TutorialUser user : users) {
                            if(payload.toString().equals(user.getMcName())) {
                                if(user.areBandanaEnabled == true) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        }
                        return "false";
                    case "setWingsEnabled":
                        String[] wingEnabledInfo = payload.toString().split(":");
                        for(TutorialUser user : users) {
                            if(wingEnabledInfo[0].equals(user.getMcName())) {
                                user.setWingsEnabled(Boolean.parseBoolean(wingEnabledInfo[1]));
//                                System.out.println(user.areUsingWings());
                            }
                        }
                        return true;
                    case "setTophatEnabled":
                        String[] tophatEnabledInfo = payload.toString().split(":");
                        for(TutorialUser user : users) {
                            if(tophatEnabledInfo[0].equals(user.getMcName())) {
                                user.setTophatEnabled(Boolean.parseBoolean(tophatEnabledInfo[1]));
//                                System.out.println(user.areUsingWings());
                            }
                        }
                        return true;
                    case "setBandanaEnabled":
                        String[] bandanaEnabledInfo = payload.toString().split(":");
                        for(TutorialUser user : users) {
                            if(bandanaEnabledInfo[0].equals(user.getMcName())) {
                                user.setBandanaEnabled(Boolean.parseBoolean(bandanaEnabledInfo[1]));
//                                System.out.println(user.areUsingWings());
                            }
                        }
                        return true;
                }
                return payload;
            }
        });

        System.out.println("Started server on port " + server.getPort());
        server.start();
    }

}