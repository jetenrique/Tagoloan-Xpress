const assetPathPrefix = "https://www.figma.com/api/mcp/asset/76ba0306-6b01-4a57-bf90-0687b07f3bd7";
const imgPhoto = `${assetPathPrefix}/91875.png`;
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgToggle = `${assetPathPrefix}/92c50.svg`;
const imgIconFood = `${assetPathPrefix}/af0d8.svg`;
const imgDot = `${assetPathPrefix}/7aa0e.svg`;
const imgDot1 = `${assetPathPrefix}/9b200.svg`;
const imgIconArrow = `${assetPathPrefix}/76d20.svg`;
const imgContainer3 = `${assetPathPrefix}/d4a60.svg`;
const imgContainer4 = `${assetPathPrefix}/91b21.svg`;
const imgContainer5 = `${assetPathPrefix}/f87a1.svg`;
const imgContainer6 = `${assetPathPrefix}/cc184.svg`;
const imgContainer7 = `${assetPathPrefix}/a4dbe.svg`;

export default function RiderDashboard() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:2022" data-name="rider dashboard">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="130:233" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="130:234" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="130:235" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:236">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="130:237" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="130:238" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="130:240" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="130:242" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex items-center overflow-clip px-[16px] py-[12px] relative shrink-0 w-full" data-node-id="130:244" data-name="Header">
          <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:245" data-name="Container">
            <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[13px] w-full" data-node-id="130:246">
              Maayong adlaw,
            </p>
            <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[20px] w-full" data-node-id="130:247">
              Juan
            </p>
          </div>
          <div className="relative shrink-0 size-[44px]" data-node-id="130:248" data-name="Photo">
            <img alt="" className="absolute block inset-0 max-w-none size-full" height="44" src={imgPhoto} width="44" />
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[20px] items-start min-h-px overflow-clip px-[16px] py-[4px] relative w-full" data-node-id="130:249" data-name="Body">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex gap-[12px] h-[100px] items-center overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:250" data-name="Status">
            <div className="bg-[#1e9e5a] relative rounded-[5px] shrink-0 size-[10px]" data-node-id="130:251" data-name="Container" />
            <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:252" data-name="Container">
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full" data-node-id="130:253">{`You're online`}</p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:254">
                Accepting requests nearby
              </p>
            </div>
            <div className="h-[28px] relative shrink-0 w-[48px]" data-node-id="130:255" data-name="Toggle">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgToggle} />
            </div>
          </div>
          <div className="[word-break:break-word] content-stretch flex gap-[10px] items-start leading-[1.35] overflow-clip relative shrink-0 w-full" data-node-id="130:257" data-name="Container">
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start min-w-px overflow-clip p-[14px] relative rounded-[16px]" data-node-id="130:258" data-name="Stat – Earnings">
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:259">
                Earnings
              </p>
              <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[20px] w-full" data-node-id="130:260">
                ₱0.00
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[11px] w-full" data-node-id="130:261">
                Today
              </p>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start min-w-px overflow-clip p-[14px] relative rounded-[16px]" data-node-id="130:262" data-name="Stat – Deliveries">
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:263">
                Deliveries
              </p>
              <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[20px] w-full" data-node-id="130:264">
                0
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[11px] w-full" data-node-id="130:265">
                Today
              </p>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start min-w-px overflow-clip p-[14px] relative rounded-[16px]" data-node-id="130:266" data-name="Stat – Rating">
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:267">
                Rating
              </p>
              <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[20px] w-full" data-node-id="130:268">
                5.0
              </p>
              <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#a3a3ab] text-[11px] w-full" data-node-id="130:269">
                Top tier
              </p>
            </div>
          </div>
          <div className="content-stretch flex flex-col gap-[12px] items-start overflow-clip relative shrink-0 w-full" data-node-id="130:270" data-name="Requests">
            <div className="content-stretch flex items-center overflow-clip relative shrink-0 w-full" data-node-id="130:271" data-name="Container">
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[16px]" data-node-id="130:272">
                Available requests
              </p>
              <div className="bg-[#fff7e0] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="130:273" data-name="Chip">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="130:274">
                  1 new
                </p>
              </div>
            </div>
            <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[14px] items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:275" data-name="Request">
              <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:276" data-name="Container">
                <div className="bg-[#fff7e0] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[40px]" data-node-id="130:277" data-name="Container">
                  <div className="relative shrink-0 size-[20px]" data-node-id="130:278" data-name="icon/food">
                    <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconFood} />
                  </div>
                </div>
                <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col gap-[2px] items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:282" data-name="Container">
                  <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] text-[15px] w-full whitespace-pre-wrap" data-node-id="130:283">{`Minute Burger  ×2`}</p>
                  <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:284">
                    Just now · 2.0 km away
                  </p>
                </div>
                <div className="bg-[#f3f1ea] content-stretch flex items-center overflow-clip px-[10px] py-[4px] relative rounded-[999px] shrink-0" data-node-id="130:285" data-name="Chip">
                  <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[12px] whitespace-nowrap" data-node-id="130:286">
                    Food
                  </p>
                </div>
              </div>
              <div className="bg-[#fbf9f1] content-stretch flex flex-col gap-[12px] items-start overflow-clip p-[14px] relative rounded-[12px] shrink-0 w-full" data-node-id="130:287" data-name="Route">
                <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:288" data-name="Container">
                  <div className="relative shrink-0 size-[8px]" data-node-id="130:289" data-name="dot">
                    <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgDot} />
                  </div>
                  <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:290" data-name="Container">
                    <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:291">
                      Pickup
                    </p>
                    <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="130:292">
                      Minute Burger, Poblacion
                    </p>
                  </div>
                </div>
                <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:293" data-name="Container">
                  <div className="relative shrink-0 size-[8px]" data-node-id="130:294" data-name="dot">
                    <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgDot1} />
                  </div>
                  <div className="[word-break:break-word] content-stretch flex flex-[1_0_0] flex-col items-start leading-[1.35] min-w-px overflow-clip relative" data-node-id="130:295" data-name="Container">
                    <p className="font-['Plus_Jakarta_Sans:Regular'] font-normal relative shrink-0 text-[#6b6b73] text-[12px] w-full" data-node-id="130:296">
                      Drop-off
                    </p>
                    <p className="font-['Plus_Jakarta_Sans:Medium'] font-medium relative shrink-0 text-[#18181f] text-[14px] w-full" data-node-id="130:297">
                      Zone 3, Mohon
                    </p>
                  </div>
                </div>
              </div>
              <div className="[word-break:break-word] content-stretch flex items-center leading-[1.35] overflow-clip relative shrink-0 w-full" data-node-id="130:298" data-name="Container">
                <div className="content-stretch flex flex-[1_0_0] flex-col font-['Plus_Jakarta_Sans:Regular'] font-normal items-start min-w-px overflow-clip relative text-[12px]" data-node-id="130:299" data-name="Container">
                  <p className="relative shrink-0 text-[#6b6b73] w-full" data-node-id="130:300">
                    Delivery fee
                  </p>
                  <p className="relative shrink-0 text-[#a3a3ab] w-full" data-node-id="130:301">
                    Cash on delivery
                  </p>
                </div>
                <p className="font-['Plus_Jakarta_Sans:Bold'] font-bold relative shrink-0 text-[#18181f] text-[22px] whitespace-nowrap" data-node-id="130:302">
                  ₱60.00
                </p>
              </div>
              <a className="bg-[#febc20] content-stretch cursor-pointer flex gap-[8px] items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="130:303" data-name="Button – View request">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="130:304">
                  View request
                </p>
                <div className="relative shrink-0 size-[16px]" data-node-id="130:305" data-name="icon/arrow">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconArrow} />
                </div>
              </a>
            </div>
          </div>
          <div className="h-[8px] relative shrink-0 w-px" data-node-id="130:308" data-name="Spacer" />
        </div>
        <div className="backdrop-blur-[12px] bg-[rgba(255,255,255,0.95)] content-stretch flex flex-col items-start relative rounded-[16px] shadow-[0px_-2px_12px_0px_rgba(0,0,0,0.05)] shrink-0 w-full" data-node-id="130:198" data-name="Nav">
          <div className="content-stretch flex h-[64px] items-center justify-between px-[4px] relative shrink-0 w-full" data-node-id="130:199" data-name="Container">
            <div className="content-stretch flex flex-col h-full items-center justify-center min-w-[44px] relative shrink-0 w-[76.39px]" data-node-id="130:200" data-name="Link">
              <div className="bg-[#febc20] content-stretch flex h-[28px] items-center justify-center relative rounded-[14px] shrink-0 w-[40px]" data-node-id="130:201" data-name="Background+Shadow">
                <div className="h-[11.667px] relative shrink-0 w-[20px]" data-node-id="130:202" data-name="Container">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer3} />
                </div>
              </div>
              <div className="content-stretch flex flex-col items-start pt-[2px] relative shrink-0" data-node-id="130:204" data-name="Margin">
                <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:205">
                  <p className="leading-[16px]">Home</p>
                </div>
              </div>
            </div>
            <div className="content-stretch flex flex-col h-full items-center justify-center min-w-[44px] relative shrink-0 w-[76.41px]" data-node-id="130:206" data-name="Link">
              <div className="content-stretch flex h-[28px] items-center justify-center relative rounded-[14px] shrink-0 w-[40px]" data-node-id="130:207" data-name="Container">
                <div className="h-[13.333px] relative shrink-0 w-[15px]" data-node-id="130:208" data-name="Container">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer4} />
                </div>
              </div>
              <div className="content-stretch flex flex-col items-start pt-[2px] relative shrink-0" data-node-id="130:210" data-name="Margin">
                <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:Medium'] font-medium justify-center leading-[0] relative shrink-0 text-[#6b6b73] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:211">
                  <p className="leading-[16px]">Requests</p>
                </div>
              </div>
            </div>
            <a className="content-stretch cursor-pointer flex flex-col h-full items-center justify-center min-w-[44px] relative shrink-0 w-[76.39px]" data-node-id="130:212" data-name="Link">
              <div className="content-stretch flex h-[28px] items-center justify-center relative rounded-[14px] shrink-0 w-[40px]" data-node-id="130:213" data-name="Container">
                <div className="h-[15.833px] relative shrink-0 w-[13.333px]" data-node-id="130:214" data-name="Container">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer5} />
                </div>
              </div>
              <div className="content-stretch flex flex-col items-start pt-[2px] relative shrink-0" data-node-id="130:216" data-name="Margin">
                <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:Medium'] font-medium justify-center leading-[0] relative shrink-0 text-[#6b6b73] text-[11px] text-left tracking-[0.5px] whitespace-nowrap" data-node-id="130:217">
                  <p className="leading-[16px]">Active</p>
                </div>
              </div>
            </a>
            <div className="content-stretch flex flex-col h-full items-center justify-center min-w-[44px] relative shrink-0 w-[76.41px]" data-node-id="130:218" data-name="Link">
              <div className="content-stretch flex h-[28px] items-center justify-center relative rounded-[14px] shrink-0 w-[40px]" data-node-id="130:219" data-name="Container">
                <div className="h-[16.667px] relative shrink-0 w-[15px]" data-node-id="130:220" data-name="Container">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer6} />
                </div>
              </div>
              <a className="content-stretch cursor-pointer flex flex-col items-start pt-[2px] relative shrink-0" data-node-id="130:222" data-name="Margin">
                <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:Medium'] font-medium justify-center leading-[0] relative shrink-0 text-[#6b6b73] text-[11px] text-left tracking-[0.5px] whitespace-nowrap" data-node-id="130:223">
                  <p className="leading-[16px]">History</p>
                </div>
              </a>
            </div>
            <div className="content-stretch flex flex-col h-full items-center justify-center min-w-[44px] relative shrink-0 w-[76.41px]" data-node-id="130:224" data-name="Link">
              <div className="content-stretch flex h-[28px] items-center justify-center relative rounded-[14px] shrink-0 w-[40px]" data-node-id="130:225" data-name="Container">
                <div className="relative shrink-0 size-[13.333px]" data-node-id="130:226" data-name="Container">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer7} />
                </div>
              </div>
              <a className="content-stretch cursor-pointer flex flex-col items-start pt-[2px] relative shrink-0" data-node-id="130:228" data-name="Margin">
                <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:Medium'] font-medium justify-center leading-[0] relative shrink-0 text-[#6b6b73] text-[11px] text-left tracking-[0.5px] whitespace-nowrap" data-node-id="130:229">
                  <p className="leading-[16px]">Profile</p>
                </div>
              </a>
            </div>
          </div>
          <div className="content-stretch flex items-start justify-center pb-[4px] relative shrink-0 w-full" data-node-id="130:230" data-name="Container">
            <div className="bg-[rgba(24,24,31,0.3)] h-[4px] relative rounded-[9999px] shrink-0 w-[128px]" data-node-id="130:231" data-name="Overlay" />
          </div>
        </div>
      </div>
    </div>
  );
}
