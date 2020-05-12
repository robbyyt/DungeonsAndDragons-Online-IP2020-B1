using System;

public class LobbyPlayer
{
    public Guid id { get; private set; }
    public int level { get; private set; }
    public String name { get; private set; }
    public Role role { get; private set; } 
    public bool muted { get; private set; }
    
    public LobbyPlayer(Guid id, int level, String name, Role role)
    {
        this.id = id;
        this.level = level;
        this.name = name;
        this.role = role;
        this.muted = false;
    }

    public void MutePlayer()
    {
        this.muted = true;
    }

    public void UnmutePlayer()
    {
        this.muted = false;
    }

    public void UpdateRole(Role role)
    {
        this.role = role;
    }

	public Role getRole(LobbyPlayer player)
	{
		return this.role;
	}

}
