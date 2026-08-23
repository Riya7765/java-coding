import java.util.Scanner;

class Team {
    protected String name;
    protected int matchesPlayed;
    protected int wins;
    protected int draws;

    public Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    public int calculatePoints() {
        return 0;
    }

    public String getSport() {
        return "Team";
    }

    @Override
    public String toString() {
        return "Team: " + name + " (" + getSport() + ") Points: " + calculatePoints();
    }
}

class CricketTeam extends Team {

    public CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        return (wins * 2) + (draws * 1);
    }

    @Override
    public String getSport() {
        return "Cricket";
    }
}

class FootballTeam extends Team {

    public FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    @Override
    public int calculatePoints() {
        return (wins * 3) + (draws * 1);
    }

    @Override
    public String getSport() {
        return "Football";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(",");

            String type = parts[0].trim();
            String name = parts[1].trim();
            int matchesPlayed = Integer.parseInt(parts[2].trim());
            int wins = Integer.parseInt(parts[3].trim());
            int draws = Integer.parseInt(parts[4].trim());

            Team team;

            if (type.equalsIgnoreCase("Cricket")) {
                team = new CricketTeam(name, matchesPlayed, wins, draws);
            } else {
                team = new FootballTeam(name, matchesPlayed, wins, draws);
            }

            System.out.println(team);
        }

        sc.close();
    }
}