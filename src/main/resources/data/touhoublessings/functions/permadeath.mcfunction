# Increment the player's permadeath count and send a global message regarding their demise
scoreboard players add @s permadeath 1
execute if score @s permadeath matches ..1 run tellraw @a {"translate":"power.touhoublessings.one_life.deathOnce","with":[{"selector":"@s","color":"red"}],"color":"dark_red"}
execute if score @s permadeath matches 2.. run tellraw @a {"translate":"power.touhoublessings.one_life.death","with":[{"selector":"@s","color":"red"},{"score":{"name":"@s","objective":"permadeath"},"color":"red"}],"color":"dark_red"}

# Reset the player's inventories and other relevant stuff

# Clear inventory and experience
clear @s
kill @e[type=minecraft:experience_orb,limit=4,distance=..1]

# Clear ender chest
item modify entity @s enderchest.0 touhoublessings:delete
item modify entity @s enderchest.1 touhoublessings:delete
item modify entity @s enderchest.2 touhoublessings:delete
item modify entity @s enderchest.3 touhoublessings:delete
item modify entity @s enderchest.4 touhoublessings:delete
item modify entity @s enderchest.5 touhoublessings:delete
item modify entity @s enderchest.6 touhoublessings:delete
item modify entity @s enderchest.7 touhoublessings:delete
item modify entity @s enderchest.8 touhoublessings:delete
item modify entity @s enderchest.9 touhoublessings:delete
item modify entity @s enderchest.10 touhoublessings:delete
item modify entity @s enderchest.11 touhoublessings:delete
item modify entity @s enderchest.12 touhoublessings:delete
item modify entity @s enderchest.13 touhoublessings:delete
item modify entity @s enderchest.14 touhoublessings:delete
item modify entity @s enderchest.15 touhoublessings:delete
item modify entity @s enderchest.16 touhoublessings:delete
item modify entity @s enderchest.17 touhoublessings:delete
item modify entity @s enderchest.18 touhoublessings:delete
item modify entity @s enderchest.19 touhoublessings:delete
item modify entity @s enderchest.20 touhoublessings:delete
item modify entity @s enderchest.21 touhoublessings:delete
item modify entity @s enderchest.22 touhoublessings:delete
item modify entity @s enderchest.23 touhoublessings:delete
item modify entity @s enderchest.24 touhoublessings:delete
item modify entity @s enderchest.25 touhoublessings:delete
item modify entity @s enderchest.26 touhoublessings:delete

# Reset advancements and recipes
advancement revoke @s everything
recipe take @s *